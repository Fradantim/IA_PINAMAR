package com.ia.tmi.iatmi.persistence.entities;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ia.tmi.iatmi.persistence.entities.Persona.RolPersona;

@Entity
public class Fichero {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private Date fechaIngreso;
	
	@Column
	private Date fechaEgreso;
	
	@ManyToOne
	@Enumerated(EnumType.STRING)
	private RolPersona rol;
	
	@Column
	private Boolean activo;
	
	@ManyToOne
	private Persona persona;
	
	public Fichero(Persona persona, RolPersona rol) {
		this.persona=persona;
		this.fechaIngreso=new Date();
		this.rol=rol;
		this.setActivo(true);
	}
	
	public Fichero() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
}
