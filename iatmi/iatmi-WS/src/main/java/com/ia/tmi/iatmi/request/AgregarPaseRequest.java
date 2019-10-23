package com.ia.tmi.iatmi.request;

public class AgregarPaseRequest {

	private Integer idPersona;
	private Integer idPase;
	
	public AgregarPaseRequest() { }
	
	public AgregarPaseRequest(Integer idPersona, Integer idPase) {
		this.idPersona = idPersona;
		this.idPase = idPase;
	}

	public Integer getIdPase() {
		return idPase;
	}

	public void setIdPase(Integer idPase) {
		this.idPase = idPase;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}	
}
