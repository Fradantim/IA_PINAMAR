package com.ia.tmi.iatmi.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.exception.TokenInvalidoException;
import com.ia.tmi.iatmi.exception.UsuarioDebeLoguearseException;

public class Endpoint{
	
	@Autowired
	protected PersonaController personaController;
	
	private static final Logger logger = LoggerFactory.getLogger(Endpoint.class);
	
	protected PersonaDTO evaluarToken(String token) {
		//TODO Login IR CONTRA LA BBDD, buscar el user al que le corresponde el token o solo evaluar que exista / posea permisos?
		logger.info("Evaluando token:'"+token+"'");
		if(token==null || token.isEmpty()) {
			throw new UsuarioDebeLoguearseException("No se proporcionó un token de autenticación.");
		}
		
		if(token.length()<2) {
			throw new TokenInvalidoException("El token proporcionado no es válido.");
		}
		
		personaController.getClass();
		return null;
	}
	
}