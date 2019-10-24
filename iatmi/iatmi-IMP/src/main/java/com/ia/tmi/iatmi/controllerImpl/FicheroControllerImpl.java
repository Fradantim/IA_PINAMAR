package com.ia.tmi.iatmi.controllerImpl;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.FicheroController;
import com.ia.tmi.iatmi.exception.PersonaNoPoseeRolNecesarioException;
import com.ia.tmi.iatmi.exception.SocioNoPoseePaseActivoException;
import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.Habilitacion;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona.RolPersonaEnum;
import com.ia.tmi.iatmi.persistence.service.FicheroService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;

@Controller
public class FicheroControllerImpl implements FicheroController{
	
	@Autowired
	private FicheroService ficheroService;
	
	@Autowired
	private PersonaService personaService;

	@Override
	public void ficharIngreso(Integer idPersona, String idRol) {
		Persona persona = personaService.findById(idPersona).get();
		RolPersona rol;
		try {
			rol = RolPersonaEnum.valueOf(idRol).getRol();
		} catch(IllegalArgumentException e) {
			throw new NoSuchElementException("No se encontro un Rol con id "+idRol);
		}
		
		if(!persona.hasRol(rol)) {
			throw new PersonaNoPoseeRolNecesarioException("La persona no posee con el perfil indicado.");
		}
		
		if(rol.equals(RolPersonaEnum.SOCIO.getRol())) {
			Habilitacion hab = persona.getHabilitacion();
			if(hab == null || hab.getHabilitadoHasta().after(new Date())) {
				throw new SocioNoPoseePaseActivoException("El socio no posee un pase activo.");
			}
		}
		
		Fichero ultimaFichada = ficheroService.findFirstByPersonaAndRolOrderByFechaIngresoDesc(persona, rol);
		
		if(ultimaFichada != null && ultimaFichada.getFechaEgreso()==null) {
			ultimaFichada.setActivo(false);
			ficheroService.save(ultimaFichada);
		}
		
		Fichero nuevaFichada = new Fichero(persona, rol);
		ficheroService.save(nuevaFichada);
	}

	@Override
	public void ficharEgreso(Integer idPersona, String idRol) {
		Persona persona = personaService.findById(idPersona).get();
		RolPersona rol;
		try {
			rol = RolPersonaEnum.valueOf(idRol).getRol();
		} catch(IllegalArgumentException e) {
			throw new NoSuchElementException("No se encontro un Rol con id "+idRol);
		}
		
		if(!persona.hasRol(rol)) {
			throw new PersonaNoPoseeRolNecesarioException("La persona no posee con el perfil indicado.");
		}
		
		Fichero ultimaFichada = ficheroService.findFirstByPersonaAndRolOrderByFechaIngresoDesc(persona, rol);
		
		if(ultimaFichada == null) {
			throw new NoSuchElementException("No se encontró una Fichada que a la cual marcar egreso.");
		}
		
		ultimaFichada.setFechaEgreso(new Date());
		ficheroService.save(ultimaFichada);
	}
}
