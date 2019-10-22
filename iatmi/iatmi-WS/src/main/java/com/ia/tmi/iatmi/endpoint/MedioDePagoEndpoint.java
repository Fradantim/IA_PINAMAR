package com.ia.tmi.iatmi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.MovimientoController;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class MedioDePagoEndpoint{
	
	private static final String PATH="/api/mediosDePago";
	
	@Autowired
	private MovimientoController movimientoController;
	
	@GetMapping(PATH)
	public WSReturn getAll(){
		return WSReturn.OK("Busqueda exitosa", movimientoController.findAll());
	}
}