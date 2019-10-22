package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class PersonaEndpoint{
	
	private static final String PATH="/api/personas";
	
	@Autowired
	private PersonaController personaController;
	
	@GetMapping(PATH)
	public WSReturn<List<PersonaDTO>> getAll(){
		return new WSReturn<List<PersonaDTO>>("Busqueda exitosa.", personaController.findAll());
	}
}