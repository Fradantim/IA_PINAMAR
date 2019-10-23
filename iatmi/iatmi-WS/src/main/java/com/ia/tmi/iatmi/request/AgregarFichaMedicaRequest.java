package com.ia.tmi.iatmi.request;

import com.ia.tmi.iatmi.dto.FichaMedicaDTO;

public class AgregarFichaMedicaRequest {

	private FichaMedicaDTO fichaMedica;
	private Integer idPersona;
	
	public AgregarFichaMedicaRequest() { }

	public AgregarFichaMedicaRequest(FichaMedicaDTO fichaMedica, Integer idPersona) {
		this.fichaMedica = fichaMedica;
		this.idPersona = idPersona;
	}

	public FichaMedicaDTO getFichaMedica() {
		return fichaMedica;
	}

	public void setFichaMedica(FichaMedicaDTO fichaMedica) {
		this.fichaMedica = fichaMedica;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
}

