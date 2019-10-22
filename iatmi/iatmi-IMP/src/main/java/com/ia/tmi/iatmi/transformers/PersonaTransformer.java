package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Persona;

@Component
public class PersonaTransformer {
	
	public PersonaDTO transform(Persona persona) {
		return new PersonaDTO(persona.getNombre(), persona.getApellido(),
				persona.getDni(), persona.getEmail(), persona.getSexo(), 
				persona.getFechaNacimiento(), persona.getFechaAlta());
	}
	
	public List<PersonaDTO> transform(List<Persona> personas) {
		return personas.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}