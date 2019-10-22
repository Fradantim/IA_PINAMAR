package com.ia.tmi.iatmi.dto;

import java.util.Date;

public class EmpleadoDTO extends PersonaDTO{

	private Integer legajo;
	
	private float sueldoBasicoCostoHora;
	
	private TipoEmpleadoDTO tipoEmpleado;
	
	public EmpleadoDTO(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Date fechaAlta, float sueldoBasicoCostoHora, TipoEmpleadoDTO tipoEmpleado) {
		super(nombre, apellido, dni, email, sexo, fechaNacimiento, fechaAlta);
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
		this.tipoEmpleado = tipoEmpleado;
	}


	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public float getSueldoBasicoCostoHora() {
		return sueldoBasicoCostoHora;
	}

	public void setSueldoBasicoCostoHora(float sueldoBasicoCostoHora) {
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}

	public TipoEmpleadoDTO getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleadoDTO tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	
}
