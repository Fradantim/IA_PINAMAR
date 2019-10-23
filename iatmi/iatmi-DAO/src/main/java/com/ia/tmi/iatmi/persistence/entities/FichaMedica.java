package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FichaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private Date fechaAlta;

	@Column
	private String nombreMedico;

	@Column
	private String telefono;

	@Column
	private String obraSocial;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Persona persona;

	public FichaMedica() {	}
	
	public FichaMedica(String nombreMedico, String telefono, String obraSocial) {
		this.nombreMedico = nombreMedico;
		this.telefono = telefono;
		this.obraSocial = obraSocial;
		this.fechaAlta= new Date();
	}
	
	public FichaMedica(String nombreMedico, String telefono, String obraSocial, Persona persona) {
		this(nombreMedico,telefono,obraSocial);
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Persona getPersona() {
		return persona;
	}
	
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
