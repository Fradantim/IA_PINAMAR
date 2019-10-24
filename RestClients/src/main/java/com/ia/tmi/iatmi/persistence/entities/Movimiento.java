package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

public abstract class Movimiento {

	private Integer id;
	
	private Date fecha;
	
	private String tipo;

	protected Float montoTotal;
	
	private Persona persona;

	public Movimiento() {}
	
	public Movimiento(Persona persona, Float montoTotal) {
		this.fecha = new Date();
		this.persona = persona;
		this.montoTotal=montoTotal;
	}
	
	public Movimiento(Persona persona) {
		this(persona, 0F);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getTipo() {
		return tipo;
	}
}
