package com.ia.tmi.iatmi.controllerImpl;

import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.LoginController;

@Controller
public class LoginControllerImpl implements LoginController{

	@Override
	public String login(String user, String pass) {
		// TODO HACER ESTO CONECTANDO A LA BBDD!!
		return user+"_"+pass;
	}	
}
