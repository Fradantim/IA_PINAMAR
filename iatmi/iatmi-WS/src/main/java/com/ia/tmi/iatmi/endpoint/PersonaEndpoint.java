package com.ia.tmi.iatmi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class PersonaEndpoint{
	
	private static final String PATH="/api/personas";
	
	@Autowired
	private PersonaController personaController;
	
	@GetMapping(PATH)
	public WSReturn getAll(
			@RequestParam(defaultValue = "false") Boolean emptyResponse
			){
		if(emptyResponse) {
			return WSReturn.ERROR("No se encontraron elementos");
		}
		return WSReturn.OK("Busqueda exitosa.", personaController.findAll());
	}
}