package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
//@DiscriminatorValue("empleado")
public class Empleado extends Persona {
	
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer legajo;
	
	@Column
	private Date fechaAlta;
	
	
	public Empleado() {	}

	public Empleado(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
