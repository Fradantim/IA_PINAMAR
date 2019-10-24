package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint;

public class FichadoRequest {

	private Integer idPersona;
	private String idRol;
	
	public FichadoRequest() {}
	
	public FichadoRequest(Integer idPersona, String idRol) {
		this.idPersona = idPersona;
		this.idRol = idRol;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getIdRol() {
		return idRol;
	}

	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}	
}
