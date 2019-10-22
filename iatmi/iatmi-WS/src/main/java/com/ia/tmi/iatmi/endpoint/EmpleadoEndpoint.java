package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.EmpleadoController;
import com.ia.tmi.iatmi.dto.EmpleadoDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class EmpleadoEndpoint {

private static final String PATH="/api/empleados";
	
	@Autowired
	private EmpleadoController empleadoController;
	
	@GetMapping(PATH+"All")
	public WSReturn<List<EmpleadoDTO>> getAll(){
		return new WSReturn<List<EmpleadoDTO>>("busqueda de los empleado con exito", empleadoController.getAll()) ;
	}
	
	@GetMapping(PATH)
	public WSReturn<EmpleadoDTO>getSocioById(
			@RequestParam(required = true) Integer legajo){
		return new WSReturn<EmpleadoDTO>("Busqueda del Empleado con exito.",empleadoController.getEmpleadoByID(legajo));
	}
	
	@PostMapping(PATH)
	public void addEmpleado( @RequestBody(required = true) EmpleadoDTO empleado) {
	    empleadoController.setEmpleado(empleado);
	}
}
