package com.ia.tmi.iatmi.request;

public class LiquidacionRequest {

	private Integer idEmpleado;
	private Integer anio;
	private Integer mes;

	public LiquidacionRequest(Integer idEmpleado, Integer anio, Integer mes) {
		super();
		this.idEmpleado = idEmpleado;
		this.anio = anio;
		this.mes = mes;
	}

	public LiquidacionRequest() {
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

}
