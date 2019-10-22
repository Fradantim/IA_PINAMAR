package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.transformers.PersonaTransformer;

@Controller
public class PersonaControllerImpl implements PersonaController{
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PersonaTransformer personaTransformer;
	
	public List<PersonaDTO> findAll(){
		return personaTransformer.transform(personaService.findAll());
	}
}
