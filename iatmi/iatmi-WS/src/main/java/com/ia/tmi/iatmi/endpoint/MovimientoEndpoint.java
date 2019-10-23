package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.MovimientoController;
import com.ia.tmi.iatmi.dto.MovimientoDTO;
import com.ia.tmi.iatmi.request.PagoFacturaRequest;
import com.ia.tmi.iatmi.wsModel.WSReturn;

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
	public WSReturn pagar(@RequestBody(required = true) PagoFacturaRequest request){
		movimientoController.pagarFactura(request.getIdFactura(),request.getIdMedioDePago());
		return WSReturn.OK("Pago grabado exitosamente.");
	}
}
