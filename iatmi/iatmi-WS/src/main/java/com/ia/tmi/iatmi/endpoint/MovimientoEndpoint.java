package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.MovimientoController;
import com.ia.tmi.iatmi.dto.MovimientoDTO;

@RestController
public class MovimientoEndpoint{
	
	private static final String PATH="/api/movimientos";
	
	@Autowired
	private MovimientoController movimientoController;
	
	@GetMapping(PATH+"All")
	public List<MovimientoDTO> getAll(){
		return movimientoController.findAll();
	}
	
	@GetMapping(PATH)
	public List<MovimientoDTO> getBySocio(
			@RequestParam(required = true) Integer idSocio
			){
		return movimientoController.findBySocio(idSocio);
	}
	
	@PostMapping(PATH)
	public void pagar(
			@RequestParam(required = true) Integer idFactura,
			@RequestParam(required = true) Integer idMedioDePago
			){
		movimientoController.pagarFactura(idFactura,idMedioDePago);
	}
}
