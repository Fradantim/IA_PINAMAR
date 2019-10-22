package com.ia.tmi.iatmi.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.SocioController;
import com.ia.tmi.iatmi.dto.SocioDTO;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class SocioEndpoint {

	private static final String PATH="/api/socios";
	
	@Autowired
	private SocioController socioController;
	
	@GetMapping(PATH+"All")
	public WSReturn<List<SocioDTO>> getAll(){
		return new WSReturn<List<SocioDTO>>("busqueda de los socios con exito", socioController.getAll()) ;
	}
	
	@GetMapping(PATH)
	public WSReturn<SocioDTO>getSocioById(
			@RequestParam(required = true) Integer idSocio){
		return new WSReturn<SocioDTO>("Busqueda del Usuario con exito.",socioController.getSocioByID(idSocio));
	}
	
	@PostMapping(PATH)
	public void addSocio( @RequestBody(required = true) SocioDTO socio) {
	    socioController.setSocio(socio);
	}
}
