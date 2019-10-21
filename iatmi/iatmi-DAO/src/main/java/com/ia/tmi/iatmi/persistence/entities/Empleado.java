package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
//@DiscriminatorValue("empleado")
public class Empleado extends Persona {
	
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer legajo;
	
	@Column
	private Date fechaAlta;
	
	@ManyToOne
	private TipoEmpleado tipoEmpleado;
	
	@Column
	private Float sueldoBasicoCostoHora;	

	public Empleado() {	}
	
	public Empleado(TipoEmpleado tipoEmpleado, Float sueldoBasicoCostoHora) {
		this(new Date(), tipoEmpleado, sueldoBasicoCostoHora);
	}
	
	public Empleado(Date fechaAlta, TipoEmpleado tipoEmpleado, Float sueldoBasicoCostoHora) {
		this.fechaAlta = fechaAlta;
		this.tipoEmpleado = tipoEmpleado;
		this.sueldoBasicoCostoHora=sueldoBasicoCostoHora;
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
	
	public Float getSueldoBasicoCostoHora() {
		return sueldoBasicoCostoHora;
	}

	public void setSueldoBasicoCostoHora(Float sueldoBasicoCostoHora) {
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}
}
