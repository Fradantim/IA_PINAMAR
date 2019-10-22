package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.ClaseController;
import com.ia.tmi.iatmi.dto.ClaseDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class ClaseEndpoint{
	
	private static final String PATH="/api/clases";
	
	@Autowired
	private ClaseController claseController;
	
	@GetMapping(PATH)
	public WSReturn<List<ClaseDTO>> getAll(){
		return new WSReturn<List<ClaseDTO>>("Busqueda exitosa", claseController.findAll());
	}
}