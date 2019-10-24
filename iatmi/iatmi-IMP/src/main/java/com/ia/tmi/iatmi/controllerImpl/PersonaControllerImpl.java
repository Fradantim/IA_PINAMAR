package com.ia.tmi.iatmi.controllerImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.FacturaDTO;
import com.ia.tmi.iatmi.dto.FichaMedicaDTO;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.exception.PersonaNoPoseeRolNecesarioException;
import com.ia.tmi.iatmi.exception.SocioYaPoseePaseActivoException;
import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.FacturaDetalle;
import com.ia.tmi.iatmi.persistence.entities.FichaMedica;
import com.ia.tmi.iatmi.persistence.entities.Habilitacion;
import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona.RolPersonaEnum;
import com.ia.tmi.iatmi.persistence.service.FacturaService;
import com.ia.tmi.iatmi.persistence.service.FichaMedicaService;
import com.ia.tmi.iatmi.persistence.service.HabilitacionService;
import com.ia.tmi.iatmi.persistence.service.PaseService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.persistence.service.TipoEmpleadoService;
import com.ia.tmi.iatmi.transformers.FacturaTransformer;
import com.ia.tmi.iatmi.transformers.FichaMedicaTransformerFromDTO;
import com.ia.tmi.iatmi.transformers.PersonaTransformer;
import com.ia.tmi.iatmi.transformers.PersonaTransformerFromDTO;

@Controller
public class PersonaControllerImpl implements PersonaController{
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PaseService paseService;
	
	@Autowired
	private FacturaService factService;
	
	@Autowired
	private HabilitacionService habService;
	
	@Autowired
	private TipoEmpleadoService tipoEmpleadoService;
	
	@Autowired
	private FichaMedicaService fichaService;
	
	
	@Autowired
	private PersonaTransformer personaTransformer;
	
	@Autowired
	private FacturaTransformer facturaTransformer;
	
	@Autowired
	private FichaMedicaTransformerFromDTO fichaMedTranFromDTO;
	
	
	@Autowired
	private PersonaTransformerFromDTO personaTransFromDTO;
	
	public List<PersonaDTO> findAll(){
		return personaTransformer.transform(personaService.findAll());
	}

	@Override
	public PersonaDTO altaSocio(PersonaDTO persona) {
		Persona p = personaTransFromDTO.transform(persona);
		p.addRol(RolPersonaEnum.SOCIO.getRol());
		
		p = personaService.save(p);
		return personaTransformer.transform(p);
	}

	@Override
	public PersonaDTO altaEmpleado(PersonaDTO persona, Float sueldoBasicoCostoHora, Integer idTipoEmpleado) {
		Persona p = personaTransFromDTO.transform(persona);
		p.addRol(RolPersonaEnum.EMPLEADO.getRol());
		p.setSueldoBasicoCostoHora(sueldoBasicoCostoHora);
		p.setTipoEmpleado(tipoEmpleadoService.findById(idTipoEmpleado).get());
		p.setCBU(persona.getCBU());
		p.setCUIT(persona.getCUIT());
		
		evaluarNuevoEmpleado(persona);
		
		//TODO enviar nuevo empleado a presentismo
		p = personaService.save(p);

		return personaTransformer.transform(p);
	}
	
	private void evaluarNuevoEmpleado(PersonaDTO p) {
		String errores ="";
		if(p.getCBU()== null || p.getCBU().length()!=22 || !isInteger(p.getCBU()) ) {
			errores += "El CBU es obligatorio y debe poseer 22 digitos numéricos. ";
		}
		
		if(p.getCUIT()== null || p.getCUIT().length()!=11 || !isInteger(p.getCUIT()) ) {
			errores += "El CUIT es obligatorio y debe poseer 11 digitos numéricos. ";
		}
		
		if(errores.length()>0) {
			throw new IllegalArgumentException(errores);
		}
	}
	
	private Boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	@Override
	public FacturaDTO asignarPase(Integer idPersona, Integer idPase) {
		Persona socio = personaService.findById(idPersona).get();
		
		if(!socio.hasRol(RolPersonaEnum.SOCIO.getRol())) {
			throw new PersonaNoPoseeRolNecesarioException("La persona requiere del rol "+RolPersonaEnum.SOCIO+" para poder realizar esta operacion.");
		}
		
		Habilitacion hab =socio.getHabilitacion();
		
		if(hab != null && hab.getHabilitadoHasta().after(new Date())) {
			throw new SocioYaPoseePaseActivoException("El socio ya posee un pase habilitado, con fecha hasta "+hab.getHabilitadoHasta());
		}
		
		Pase pase = paseService.findById(idPase).get();
		
		Habilitacion nuevaHab = new Habilitacion(socio, pase);
		
		socio.setHabilitacion(nuevaHab);
		
		habService.save(nuevaHab);
		personaService.save(socio);
		
		Factura factura = new Factura(socio);
		
		factura.addFacturaDetalle(new FacturaDetalle(pase, factura));
		
		factura = factService.save(factura);
		return facturaTransformer.transform(factura);
	}

	@Override
	public List<PersonaDTO> findEmpleados() {
		return personaTransformer.transform(personaService.findByRolPersona(RolPersonaEnum.EMPLEADO.getRol()));
	}

	@Override
	public List<PersonaDTO> findProfesores() {
		return personaTransformer.transform(personaService.findProfesores());
	}

	@Override
	public List<PersonaDTO> findSocios() {
		return personaTransformer.transform(personaService.findByRolPersona(RolPersonaEnum.SOCIO.getRol()));
	}

	@Override
	public void addFichaMedica(FichaMedicaDTO fichaMedica, Integer idPersona) {
		Persona persona = personaService.findById(idPersona).get();
		
		if(!persona.hasRol(RolPersonaEnum.SOCIO.getRol())) {
			throw new PersonaNoPoseeRolNecesarioException("Solo los usuarios de tipo "+ RolPersonaEnum.SOCIO+ " pueden agregar FichaMedica.");
		}
		
		FichaMedica ficha = fichaMedTranFromDTO.transform(fichaMedica);
		ficha.setPersona(persona);
		
		fichaService.save(ficha);
	}
}
