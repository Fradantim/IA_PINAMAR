package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class PersonaEndpoint{
	
	public static final String PATH="/api/personas";
	
	public static final String PATH_SOCIO="/api/socios";
	
	public static final String PATH_EMPLEADOS="/api/empleados";
	
	@Autowired
	private PersonaController personaController;
	
	@GetMapping(PATH)
	public WSReturn<List<PersonaDTO>> getAll(){
		return new WSReturn<List<PersonaDTO>>("Busqueda exitosa.", personaController.findAll());
	}
	
	@PostMapping(PATH_SOCIO)
	public WSReturn<PersonaDTO> crearSocio(@RequestBody PersonaDTO socio){
		PersonaDTO socioNuevo = personaController.altaSocio(socio);
		return new WSReturn<PersonaDTO>("Alta exitosa.", socioNuevo);
	}
	
	@PostMapping(PATH_EMPLEADOS)
	public WSReturn<PersonaDTO> crearEmpleado(
			@RequestBody  PersonaDTO empleado,
			@RequestBody  Float sueldoBasicoCostoHora,
			@RequestBody  Integer idTipoEmpleado
			){
		PersonaDTO empleadoNuevo = personaController.altaEmpleado(empleado, sueldoBasicoCostoHora, idTipoEmpleado);
		return new WSReturn<PersonaDTO>("Alta exitosa.", empleadoNuevo);
	}
}