package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;

@Component
public class PersonaTransformer {
	
	public PersonaDTO transform(Persona persona) {
		PersonaDTO p = new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(),
				persona.getDni(), persona.getEmail(), persona.getSexo(), 
				persona.getFechaNacimiento(), persona.getFechaAlta());
		if(persona.getRoles() != null) {			
			for(RolPersona rol : persona.getRoles()) {
				p.addRol(rol.getId());
			}
		}
		return p;
	}
	
	public List<PersonaDTO> transform(List<Persona> personas) {
		return personas.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}