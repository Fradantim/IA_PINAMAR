package com.ia.tmi.iatmi.remoteEndpoint.banco;

public class WSBancoReturn <T>{

	private String message;
	
	private Boolean success;

	private T content;
	
	public WSBancoReturn() {
	}

	public WSBancoReturn(String message, T content) {
		this.message = message;
		this.success = true;
		this.content = content;
	}

	public WSBancoReturn(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}

	public WSBancoReturn(String message) {
		this(message, true);
	}

	@SuppressWarnings("rawtypes")
	public static WSBancoReturn OK(String message) {
		return new WSBancoReturn(message);
	}

	@SuppressWarnings("rawtypes")
	public static WSBancoReturn ERROR(String message) {
		return new WSBancoReturn(message, false);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
	
}
