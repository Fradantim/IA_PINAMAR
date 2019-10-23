package com.ia.tmi.iatmi.request;

import com.ia.tmi.iatmi.dto.PersonaDTO;

public class AltaEmpleadoRequest {

	private PersonaDTO persona;
	
	private Float sueldoBasicoCostoHora;

	private Integer idTipoEmpleado;

	public AltaEmpleadoRequest() { }
	
	public AltaEmpleadoRequest(PersonaDTO persona, Float sueldoBasicoCostoHora, Integer idTipoEmpleado) {
		this.persona = persona;
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	public Integer getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(Integer idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public Float getSueldoBasicoCostoHora() {
		return sueldoBasicoCostoHora;
	}

	public void setSueldoBasicoCostoHora(Float sueldoBasicoCostoHora) {
		this.sueldoBasicoCostoHora = sueldoBasicoCostoHora;
	}
}
