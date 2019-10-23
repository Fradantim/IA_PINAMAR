package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.request.AgregarFichaMedicaRequest;
import com.ia.tmi.iatmi.request.AltaEmpleadoRequest;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class PersonaEndpoint{
	
	public static final String PATH="/api/personas";
	
	public static final String PATH_SOCIOS="/api/socios";
	
	public static final String PATH_EMPLEADOS="/api/empleados";
	
	public static final String PATH_PROFESORES="/api/profesores";
	
	@Autowired
	private PersonaController personaController;
	
	@GetMapping(PATH)
	public WSReturn<List<PersonaDTO>> getAll(){
		return new WSReturn<List<PersonaDTO>>("Busqueda exitosa.", personaController.findAll());
	}
	
	@PostMapping(PATH_SOCIOS)
	public WSReturn<PersonaDTO> crearSocio(@RequestBody PersonaDTO socio){
		PersonaDTO socioNuevo = personaController.altaSocio(socio);
		return new WSReturn<PersonaDTO>("Alta exitosa.", socioNuevo);
	}
	
	@PostMapping(PATH_EMPLEADOS)
	public WSReturn<PersonaDTO> crearEmpleado(@RequestBody  AltaEmpleadoRequest request ){
		PersonaDTO empleadoNuevo = personaController.altaEmpleado(request.getPersona(), request.getSueldoBasicoCostoHora(), request.getIdTipoEmpleado());
		return new WSReturn<PersonaDTO>("Alta exitosa.", empleadoNuevo);
	}
	
	@GetMapping(PATH_EMPLEADOS)
	public WSReturn<List<PersonaDTO>> getEmpleados(){
		return new WSReturn<List<PersonaDTO>>("Búsqueda exitosa.", personaController.findEmpleados());
	}

	@GetMapping(PATH_PROFESORES)
	public WSReturn<List<PersonaDTO>> getProfesores(){
		return new WSReturn<List<PersonaDTO>>("Búsqueda exitosa.", personaController.findProfesores());
	}
	
	@GetMapping(PATH_SOCIOS)
	public WSReturn<List<PersonaDTO>> getSocios(){
		return new WSReturn<List<PersonaDTO>>("Búsqueda exitosa.", personaController.findSocios());
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(PATH_SOCIOS+"/FM")
	public WSReturn agregarFacturaMedica(@RequestBody(required = true) AgregarFichaMedicaRequest request){
		personaController.addFichaMedica(request.getFichaMedica(), request.getIdPersona());
		return WSReturn.OK("Búsqueda exitosa.");
	}
	
	
}