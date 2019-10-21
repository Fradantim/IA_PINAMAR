package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.service.PersonaService;

@Service
public class PersonaControllerImpl implements PersonaController{
	
	public Persona transform(PersonaDTO persona) {
		return new Persona(persona.getId(),persona.getNombre());
	}
	
	public PersonaDTO transform(Persona persona) {
		return new PersonaDTO(persona.getId(),persona.getNombre());
	}
	
	private static final List<PersonaDTO> personas = Arrays.asList(
			new PersonaDTO(1, "Franco"),
			new PersonaDTO(2, "Juan"),
			new PersonaDTO(3, "Ezequiel"));
	
	@Autowired
	private PersonaService personaService;
	
	public List<PersonaDTO> findAll(){
		List<Persona> personasEncontradas = personaService.findAll();
		if(personasEncontradas.size()==0) {
			for(PersonaDTO persona : personas) {
				personaService.save(transform(persona));
			}
			personasEncontradas = personaService.findAll();
		}
		
		List<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		
		for(Persona persona : personasEncontradas) {
			personas.add(transform(persona));
		}
		
		return personas;
	}
}
