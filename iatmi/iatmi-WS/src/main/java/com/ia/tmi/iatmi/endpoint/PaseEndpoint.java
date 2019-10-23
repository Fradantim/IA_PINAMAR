package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PaseController;
import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.FacturaDTO;
import com.ia.tmi.iatmi.dto.PaseDTO;
import com.ia.tmi.iatmi.request.AgregarPaseRequest;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class PaseEndpoint{
	
	private static final String PATH="/api/pases";
	
	@Autowired
	private PaseController paseController;
	
	@Autowired
	private PersonaController personaController;
	
	@GetMapping(PATH)
	public WSReturn<List<PaseDTO>> getAll(){
		return new WSReturn<List<PaseDTO>>("Busqueda exitosa", paseController.findAll());
	}
	
	@PostMapping(PATH)
	public WSReturn<FacturaDTO> addPase(@RequestBody AgregarPaseRequest request){
		return new WSReturn<FacturaDTO>("Asociación exitosa", personaController.asignarPase(request.getIdPersona(), request.getIdPase()));
	}
}