package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

public class FichaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private Date fechaAlta;

	@Column
	private String nombreMedico;

	@Column
	private String telefono;

	@Column
	private String obraSocial;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nroSocio", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Habilitacion socio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public FichaMedica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Habilitacion getSocio() {
		return socio;
	}

	public void setSocio(Habilitacion socio) {
		this.socio = socio;
	}

}
