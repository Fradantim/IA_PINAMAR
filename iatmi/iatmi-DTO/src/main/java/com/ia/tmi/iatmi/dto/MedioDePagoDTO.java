package com.ia.tmi.iatmi.dto;

public class MedioDePagoDTO {
	
	private Integer id;
	
	private String nombre;
	
	private Boolean esTarjeta;

	public MedioDePagoDTO(Integer id, String nombre, Boolean esTarjeta) {
		this.id = id;
		this.nombre = nombre;
		this.esTarjeta = esTarjeta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEsTarjeta() {
		return esTarjeta;
	}

	public void setEsTarjeta(Boolean esTarjeta) {
		this.esTarjeta = esTarjeta;
	}
}
