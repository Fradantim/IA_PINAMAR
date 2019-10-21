package com.ia.tmi.iatmi.endpoint;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;

@RestController
public class PersonaEndpoint{
	
	private static final String PATH="/api/personas";
	
	@Autowired
	private PersonaController personaController;
	
	@GetMapping(PATH)
	public List<PersonaDTO> getAll(
			@RequestParam(defaultValue = "false") Boolean emptyResponse
			){
		if(emptyResponse) {
			return Collections.emptyList();
		}
		return personaController.findAll();
	}
}
