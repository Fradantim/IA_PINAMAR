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

@RestController
public class SocioEndpoint {

	private static final String PATH="/api/socios";
	
	@Autowired
	private SocioController socioController;
	
	@GetMapping(PATH+"All")
	public List<SocioDTO> getAll(){
		return socioController.getAll();
	}
	
	@GetMapping(PATH)
	public SocioDTO getSocioById(
			@RequestParam(required = true) Integer idSocio){
		return socioController.getSocioByID(idSocio);
	}
	
	@PostMapping(PATH)
	public void addMember(@RequestBody SocioDTO socio) {
	    socioController.setSocio(socio);
	}
}
