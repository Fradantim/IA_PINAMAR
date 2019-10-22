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
	
	@ManyToOne
	private TipoEmpleado tipoEmpleado;
	
	@Column
	private Float sueldoBasicoCostoHora;	

	public Empleado() {	}
	
	public Empleado(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Integer legajo, TipoEmpleado tipoEmpleado, Float sueldoBasicoCostoHora) {
		super(nombre, apellido, dni, email, sexo, fechaNacimiento);
		this.legajo = legajo;
		this.setTipoEmpleado(tipoEmpleado);
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	
	public Float getSueldoBasicoCostoHora() {
		return sueldoBasicoCostoHora;
	}

	public void setSueldoBasicoCostoHora(Float sueldoBasicoCostoHora) {
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
}
