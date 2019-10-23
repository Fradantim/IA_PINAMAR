package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.LiquidacionController;
import com.ia.tmi.iatmi.dto.MovimientoDTO;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class LiquidacionEndpoint {

	public static final String PATH = "/api/liquidacion";

	@Autowired
	public LiquidacionController liquidacionController;

	@PostMapping(PATH)
	public WSReturn crearLiquidacion(@RequestBody PersonaDTO empleado) {
		liquidacionController.guardarLiquidacion(empleado.getId(), 2019, 10);
		return WSReturn.OK("Alta Exitosa de la Liquidacion");
	}

	@GetMapping(PATH)
	public List<PersonaDTO> getByEmpleadoByMesAnio(@RequestParam(required = true) Integer mes,
			@RequestParam(required = true) Integer anio) {
		return liquidacionController.findPersonaLiquidacionAnioMesAll(anio, mes);
	}

}
