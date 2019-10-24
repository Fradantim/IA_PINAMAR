package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco;

public class WSRemoteReturn<T> {

	
	private String message;
	
	private Boolean success;

	private T content;

	public WSRemoteReturn() {
	}

	public WSRemoteReturn(String message, T content) {
		this.message = message;
		this.success = true;
		this.content = content;
	}

	public WSRemoteReturn(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}

	public WSRemoteReturn(String message) {
		this(message, true);
	}

	@SuppressWarnings("rawtypes")
	public static WSRemoteReturn OK(String message) {
		return new WSRemoteReturn(message);
	}

	@SuppressWarnings("rawtypes")
	public static WSRemoteReturn ERROR(String message) {
		return new WSRemoteReturn(message, false);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Object getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
}
