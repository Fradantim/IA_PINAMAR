package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PaseController;
import com.ia.tmi.iatmi.dto.PaseDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class PaseEndpoint{
	
	private static final String PATH="/api/pases";
	
	@Autowired
	private PaseController paseController;
	
	@GetMapping(PATH)
	public WSReturn<List<PaseDTO>> getAll(){
		return new WSReturn<List<PaseDTO>>("Busqueda exitosa", paseController.findAll());
	}
}