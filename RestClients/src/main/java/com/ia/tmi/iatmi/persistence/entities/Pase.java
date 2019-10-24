package com.ia.tmi.iatmi.persistence.entities;

public class Pase {	

	private Integer id;
	
	private Integer cantidadDias;
	
	private String nombre;	
	
	private Boolean activo;
	
	private Float precio;

	public Pase(Integer cantidadDias, String nombre, Float precio) {
		this.cantidadDias = cantidadDias;
		this.nombre=nombre;
		this.precio= precio;
		this.activo=true;
	}
	
	public Pase() {	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidadDias() {
		return cantidadDias;
	}

	public void setCantidadDias(Integer cantidadDias) {
		this.cantidadDias = cantidadDias;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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
