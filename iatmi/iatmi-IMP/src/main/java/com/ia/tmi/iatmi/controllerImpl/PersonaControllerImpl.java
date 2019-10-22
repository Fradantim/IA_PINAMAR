package com.ia.tmi.iatmi.controllerImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.FacturaDTO;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.exception.SocioYaPoseePaseActivoException;
import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.FacturaDetalle;
import com.ia.tmi.iatmi.persistence.entities.Habilitacion;
import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.Persona.RolPersona;
import com.ia.tmi.iatmi.persistence.service.FacturaService;
import com.ia.tmi.iatmi.persistence.service.HabilitacionService;
import com.ia.tmi.iatmi.persistence.service.PaseService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.persistence.service.TipoEmpleadoService;
import com.ia.tmi.iatmi.transformers.FacturaTransformer;
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
	private PersonaTransformer personaTransformer;
	
	@Autowired
	private FacturaTransformer facturaTransformer;
	
	
	@Autowired
	private PersonaTransformerFromDTO personaTransFromDTO;
	
	public List<PersonaDTO> findAll(){
		return personaTransformer.transform(personaService.findAll());
	}

	@Override
	public PersonaDTO altaSocio(PersonaDTO persona) {
		Persona p = personaTransFromDTO.transform(persona);
		p.addRol(RolPersona.SOCIO);
		
		p = personaService.save(p);
		return personaTransformer.transform(p);
	}

	@Override
	public PersonaDTO altaEmpleado(PersonaDTO persona, Float sueldoBasicoCostoHora, Integer idTipoEmpleado) {
		Persona p = personaTransFromDTO.transform(persona);
		p.addRol(RolPersona.EMPLEADO);
		p.setSueldoBasicoCostoHora(sueldoBasicoCostoHora);
		
		p.setTipoEmpleado(tipoEmpleadoService.findById(idTipoEmpleado).get());
		
		p = personaService.save(p);

		return personaTransformer.transform(p);
	}

	@Override
	public FacturaDTO asignarPase(PersonaDTO persona, Integer idPase) {
		//TODO RETORNAR FACTURA DTO CON DETALLES
		Persona socio = personaService.findById(persona.getId()).get();
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
}
