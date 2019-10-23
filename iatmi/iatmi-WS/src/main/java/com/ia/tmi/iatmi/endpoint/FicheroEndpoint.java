package com.ia.tmi.iatmi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.FicheroController;
import com.ia.tmi.iatmi.request.FichadoRequest;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class FicheroEndpoint{
	
	public static final String PATH="/api/fichero";
	
	@Autowired
	private FicheroController ficheroController;
	
	@SuppressWarnings("rawtypes")
	@PostMapping(PATH+"/ingreso")
	public WSReturn ficharIngreso(@RequestBody FichadoRequest request){
		ficheroController.ficharIngreso(request.getIdPersona(), request.getIdRol());
		return WSReturn.OK("Ingreso Exitoso.");
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(PATH+"/egreso")
	public WSReturn ficharEgreso(@RequestBody FichadoRequest request){
		ficheroController.ficharEgreso(request.getIdPersona(), request.getIdRol());
		return WSReturn.OK("Egreso Exitoso.");
	}
}