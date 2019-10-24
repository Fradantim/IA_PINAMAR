package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import java.util.Date;

import com.ia.tmi.iatmi.persistence.entities.Fichero;

public class FicharPresentismoRequest {

	public enum FicharPresentismoRequestType{
		INGRESO,EGRESO
	}
	
	private String cuitEmployee;
	private String type;
	private String event;
	private String note;
	
	public FicharPresentismoRequest() { }
	
	public FicharPresentismoRequest(String cuitEmployee, FicharPresentismoRequestType type, Date event, String note) {
		this.cuitEmployee = cuitEmployee;
		this.type = type.name();
		this.event = event.toInstant().toString();
		this.note = note;
	}
	
	public FicharPresentismoRequest(Fichero fichero, FicharPresentismoRequestType type, Date event, String note) {
		this(fichero.getPersona().getCUIT(),type,event,note);
	}
	
	public FicharPresentismoRequest(Fichero fichero, FicharPresentismoRequestType type, String note) {
		this(fichero.getPersona().getCUIT(),type, new Date(),note);
	}
	
	public FicharPresentismoRequest(Fichero fichero, FicharPresentismoRequestType type) {
		this(fichero.getPersona().getCUIT(),type, new Date(),"");
	}

	public String getCuitEmployee() {
		return cuitEmployee;
	}

	public void setCuitEmployee(String cuitEmployee) {
		this.cuitEmployee = cuitEmployee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "FicharPresentismoRequest [cuitEmployee=" + cuitEmployee + ", type=" + type + ", event=" + event + ", note="
				+ note + "]";
	}
}
