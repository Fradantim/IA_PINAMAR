package com.ia.tmi.iatmi.remoteEndpoint.banco;

public class WSBancarioResponse <T>{

	private String message;
	
	private Boolean success;

	private T content;
	
	public WSBancarioResponse() {
	}

	public WSBancarioResponse(String message, T content) {
		this.message = message;
		this.success = true;
		this.content = content;
	}

	public WSBancarioResponse(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}

	public WSBancarioResponse(String message) {
		this(message, true);
	}

	@SuppressWarnings("rawtypes")
	public static WSBancarioResponse OK(String message) {
		return new WSBancarioResponse(message);
	}

	@SuppressWarnings("rawtypes")
	public static WSBancarioResponse ERROR(String message) {
		return new WSBancarioResponse(message, false);
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

	@Override
	public String toString() {
		return "WSBancarioResponse [message=" + message + ", success=" + success + "]";
	}
	
}
