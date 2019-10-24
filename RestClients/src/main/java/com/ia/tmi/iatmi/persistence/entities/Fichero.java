package com.ia.tmi.iatmi.persistence.entities;

import java.time.temporal.ChronoUnit;
import java.util.Date;


public class Fichero {

	private Integer id;
	
	private Date fechaIngreso;
	
	private Date fechaEgreso;
	
	private Boolean activo;
	
	private Persona persona;
	
	public Fichero(Persona persona, Date fechaIngreso, Date fechaEgreso) {
		this.persona=persona;
		this.fechaEgreso=fechaEgreso;
		this.fechaIngreso=fechaIngreso;
		this.setActivo(true);
	}
	
	public Fichero(Persona persona) {
		this.persona=persona;
		this.setActivo(true);
	}
	
	public Fichero() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
	public Integer getCantidadDeHoras() {
		return (int) ChronoUnit.HOURS.between(fechaIngreso.toInstant(),fechaEgreso.toInstant());
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
