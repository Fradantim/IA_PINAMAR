package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.LiquidacionController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.request.LiquidacionRequest;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class LiquidacionEndpoint {

	public static final String PATH = "/api/liquidaciones";

	@Autowired
	public LiquidacionController liquidacionController;

	@PostMapping(PATH)
	public WSReturn crearLiquidacion(@RequestBody(required=true) LiquidacionRequest request) {
		liquidacionController.guardarLiquidacion(request.getIdEmpleado(), request.getAnio(), request.getMes());
		return WSReturn.OK("Alta Exitosa de la Liquidacion");
	}

	@GetMapping(PATH)
	public WSReturn<List<PersonaDTO>> getByEmpleadoByMesAnio(@RequestParam(required = true) Integer mes,
			@RequestParam(required = true) Integer anio) {
		return new WSReturn<List<PersonaDTO>>("Busqueda OK.", liquidacionController.findPersonaLiquidacionAnioMesAll(anio, mes));
	}
	
	@PatchMapping(PATH)
	public WSReturn pagarLiquidaciones(@RequestBody(required=true) LiquidacionRequest request) {
		liquidacionController.depositarLiquidaciones(request.getAnio(), request.getMes());
		return WSReturn.OK("Sueldos Pagos Exitosamente!!!");
	}
	
	@PatchMapping(PATH+"/nominas")
	public WSReturn pagarNominaDeLiquidaciones(@RequestBody(required=true) LiquidacionRequest request) {
		liquidacionController.depositarNominaDeLiquidaciones(request.getAnio(), request.getMes());
		return WSReturn.OK("Sueldos Pagos Nominas exitosamente!!!");
	}

	@GetMapping(PATH+"/pagar")
	public WSReturn<List<PersonaDTO>> getByEmpleadoByPayMesAnio(@RequestParam(required = true) Integer mes,
			@RequestParam(required = true) Integer anio) {
		return new WSReturn<List<PersonaDTO>>("Busqueda OK.", liquidacionController.getPersonasAPagar(anio, mes));
	}
}
