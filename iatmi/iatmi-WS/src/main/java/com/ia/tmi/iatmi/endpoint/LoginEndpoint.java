package com.ia.tmi.iatmi.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ia.tmi.iatmi.controller.LoginController;
import com.ia.tmi.iatmi.wsModel.WSReturn;

@RestController
public class LoginEndpoint{
	
	private static final String PATH="/api/login";
	
	@Autowired
	private LoginController loginController;
	
	@GetMapping(PATH)
	public WSReturn<String> login(
			@RequestParam(required = true) String user,
			@RequestParam(required = true) String pass
			){
		return new WSReturn<String>("Token encontrado.", loginController.login(user, pass));
	}
}