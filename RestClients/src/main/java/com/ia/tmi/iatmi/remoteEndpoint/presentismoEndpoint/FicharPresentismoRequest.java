package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import java.util.Date;

import com.ia.tmi.iatmi.persistence.entities.Fichero;

public class FicharPresentismoRequest {

	public enum FicharPresentismoRequestType{
		INGRESO,EGRESO
	}
	
	private String idEmployee;
	private String type;
	private Date event;
	private String note;
	
	public FicharPresentismoRequest() { }
	
	public FicharPresentismoRequest(String idEmployee, FicharPresentismoRequestType type, Date event, String note) {
		this.idEmployee = idEmployee;
		this.type = type.name();
		this.event = event;
		this.note = note;
	}
	
	public FicharPresentismoRequest(Fichero fichero, FicharPresentismoRequestType type, Date event, String note) {
		this(fichero.getPersona().getIdSistemaPresentismo(),type,event,note);
	}
	
	public FicharPresentismoRequest(Fichero fichero, FicharPresentismoRequestType type, String note) {
		this(fichero.getPersona().getIdSistemaPresentismo(),type, new Date(),note);
	}
	
	public FicharPresentismoRequest(Fichero fichero, FicharPresentismoRequestType type) {
		this(fichero.getPersona().getIdSistemaPresentismo(),type, new Date(),"");
	}

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEvent() {
		return event;
	}

	public void setEvent(Date event) {
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
		return "FicharPresentismoRequest [idEmployee=" + idEmployee + ", type=" + type + ", event=" + event + ", note="
				+ note + "]";
	}
}
