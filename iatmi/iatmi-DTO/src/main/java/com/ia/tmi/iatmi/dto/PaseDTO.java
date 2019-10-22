package com.ia.tmi.iatmi.dto;

public class PaseDTO {
	
	private Integer id;
	
	private String nombre;
	
	private Float precio;
	
	public PaseDTO(Integer id, Float precio, String nombre) {
		this.id = id;
		this.precio = precio;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
