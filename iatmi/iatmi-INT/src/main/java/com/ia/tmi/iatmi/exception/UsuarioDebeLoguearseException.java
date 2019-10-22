package com.ia.tmi.iatmi.exception;

public class UsuarioDebeLoguearseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioDebeLoguearseException(String message){
		super(message);
	}
}
