package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.TipoEmpleadoController;
import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class TipoEmpleadoEndpoint{
	
	private static final String PATH="/api/tiposEmpleado";
	
	@Autowired
	private TipoEmpleadoController tipoEmpController;
	
	@GetMapping(PATH)
	public WSReturn<List<TipoEmpleadoDTO>> getAll(){
		return new WSReturn<List<TipoEmpleadoDTO>>("Busqueda exitosa", tipoEmpController.findAll());
	}
}