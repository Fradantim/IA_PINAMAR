package com.ia.tmi.iatmi.wsModel;

public class WSReturn <T> {

	private String message;
	
	private Boolean successful;
	
	private T content;

	public WSReturn(String message, T content) {
		this.message = message;
		this.successful = true;
		this.content = content;
	}
	
	public WSReturn(String message, Boolean successful) {
		this.message = message;
		this.successful=successful;
	}
	
	public WSReturn(String message) {
		this(message, true);
	}

	@SuppressWarnings("rawtypes")
	public static WSReturn OK(String message) {
		return new WSReturn(message);
	}
	
	@SuppressWarnings("rawtypes")
	public static WSReturn ERROR(String message) {
		return new WSReturn(message, false);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getSuccessful() {
		return successful;
	}

	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}	
}
