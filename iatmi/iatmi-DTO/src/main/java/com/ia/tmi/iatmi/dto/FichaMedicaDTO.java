package com.ia.tmi.iatmi.dto;

import java.util.Date;

public class FichaMedicaDTO {

	private Date fechaAlta;

	private String nombreMedico;

	private String telefono;

	private String obraSocial;
	
	public FichaMedicaDTO() {	}
	
	public FichaMedicaDTO(String nombreMedico, String telefono, String obraSocial) {
		this.nombreMedico = nombreMedico;
		this.telefono = telefono;
		this.obraSocial = obraSocial;
		this.fechaAlta= new Date();
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
}
