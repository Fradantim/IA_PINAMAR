package com.ia.tmi.iatmi.remoteEndpoint.entidadDebitoEndpoint;

public class EntidadDebitoPagarResponse {
	
	private String message;

	public EntidadDebitoPagarResponse() { }
	
	public EntidadDebitoPagarResponse(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "EntidadDebitoPagarResponse [message=" + message + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
