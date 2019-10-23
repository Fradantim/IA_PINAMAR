package com.ia.tmi.iatmi.controllerImpl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.FicheroController;
import com.ia.tmi.iatmi.persistence.entities.Fichero;
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
		
		Fichero ultimaFichada = ficheroService.findFirstByPersonaAndRolOrderByFechaIngresoDesc(persona, rol);
		
		if(ultimaFichada != null && ultimaFichada.getFechaEgreso()==null) {
			ultimaFichada.setActivo(false);
			ficheroService.save(ultimaFichada);
		}
		
		//TODO Continuar fichereada
		//Fichero fichero ultimaFichada = ficheroService
	}

	@Override
	public void ficharEgreso(Integer idPersona, String idRol) {
		// TODO Auto-generated method stub
		
	}
}
