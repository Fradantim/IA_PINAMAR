package com.ia.tmi.iatmi.endpoint;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaEndpoint{
	
	public static final String PATH="/api/personas";
	
//	@Autowired
//	private PersonaController personaController;
//	
//	@GetMapping(PATH)
//	public WSReturn<List<PersonaDTO>> getAll(){
//		return new WSReturn<List<PersonaDTO>>("Busqueda exitosa.", personaController.findAll());
//	}
}