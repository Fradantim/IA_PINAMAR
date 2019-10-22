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
	
	public WSReturn(String message) {
		this.message = message;
		this.successful = false;
	}

	/*public static WSReturn OK(String message, Object content) {
		return new WSReturn(message, content);
	}*/
	
	@SuppressWarnings("rawtypes")
	public static WSReturn ERROR(String message) {
		return new WSReturn(message);
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
