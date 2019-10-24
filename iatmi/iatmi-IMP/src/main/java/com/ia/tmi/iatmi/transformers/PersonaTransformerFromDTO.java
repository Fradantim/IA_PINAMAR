package com.ia.tmi.iatmi.transformers;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Persona;

@Component
public class PersonaTransformerFromDTO extends Transformer<PersonaDTO, Persona> {
	
	public PersonaDTO transform(Persona persona) {
		return new PersonaDTO(persona.getNombre(), persona.getApellido(),
				persona.getDni(), persona.getEmail(), persona.getSexo(), 
				persona.getFechaNacimiento(), persona.getFechaAlta());
	}

	@Override
	public Persona transform(PersonaDTO element) {
		return new Persona(element.getNombre(), element.getApellido(), element.getDni(),
				element.getEmail(), element.getSexo(), element.getFechaNacimiento(), element.getCuit(), element.getCbu());
	}
}