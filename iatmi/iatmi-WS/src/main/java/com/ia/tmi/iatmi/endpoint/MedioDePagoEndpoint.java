package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.MedioDePagoController;
import com.ia.tmi.iatmi.dto.MedioDePagoDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class MedioDePagoEndpoint extends Endpoint{
	
	private static final String PATH="/api/mediosDePago";
	
	@Autowired
	private MedioDePagoController mdpController;
	
	@GetMapping(PATH)
	public WSReturn<List<MedioDePagoDTO>> getAll(
			){
		//evaluarToken(token);
		return new WSReturn<List<MedioDePagoDTO>>("Busqueda exitosa", mdpController.findAll());
	}
}