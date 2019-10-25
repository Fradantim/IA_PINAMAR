package com.ia.tmi.iatmi.remoteEndpoint.banco;

import java.util.List;

public class WSDespositarResponse<T> {

	@SuppressWarnings("rawtypes")
	private List<WSBancarioResponse> message;
	
	private Boolean success;

	private T content;

	@SuppressWarnings("rawtypes")
	public WSDespositarResponse(List<WSBancarioResponse> message, Boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	@SuppressWarnings("rawtypes")
	public WSDespositarResponse(List<WSBancarioResponse> message) {
		super();
		this.message = message;
	}

	public WSDespositarResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public WSDespositarResponse(List<WSBancarioResponse> message, T content) {
		super();
		this.message = message;
		this.content = content;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static WSDespositarResponse OK(List<WSBancarioResponse> message) {
		return new WSDespositarResponse(message);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static WSDespositarResponse ERROR(List<WSBancarioResponse> message) {
		return new WSDespositarResponse(message, false);
	}

	@SuppressWarnings("rawtypes")
	public List<WSBancarioResponse> getMessage() {
		return message;
	}

	@SuppressWarnings("rawtypes")
	public void setMessage(List<WSBancarioResponse> message) {
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
	
	public String toStringListMsj(){
		String msj = "";
		for (@SuppressWarnings("rawtypes") WSBancarioResponse bancoReturn : getMessage()) {
			msj = msj + "s- "+ bancoReturn.toString() +"\n";
		}
		return msj;
	}

	@Override
	public String toString() {
		return "WSDespositarResponse [message=" + toStringListMsj() + ", success=" + success + "]";
	}

	
	
}
