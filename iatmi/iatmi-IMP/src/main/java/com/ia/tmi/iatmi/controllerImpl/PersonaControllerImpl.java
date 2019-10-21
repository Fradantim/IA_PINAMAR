package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.service.PersonaService;

@Controller
public class PersonaControllerImpl implements PersonaController{
	
	public Socio transform(PersonaDTO persona) {
		Socio socio = new Socio();
		socio.setId(persona.getId());
		socio.setNombre(persona.getNombre());
		return socio;
	}
	
	public PersonaDTO transform(Persona persona) {
		return new PersonaDTO(persona.getId(),persona.getNombre());
	}
	
	private static final List<PersonaDTO> personas = Arrays.asList(
			new PersonaDTO(1, "Franco"),
			new PersonaDTO(2, "Juan"),
			new PersonaDTO(3, "Ezequiel"),
			new PersonaDTO(4, "Licha"),
			new PersonaDTO(5, "Ale"));
	
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
