package com.ia.tmi.iatmi.dto;

public class PaseDTO {
	
	private Integer id;
	
	private String tipoPase;
	
	private Float precio;
	
	private String estado;

	public PaseDTO(Integer id, String tipoPase, Float precio, String estado) {
		this.id = id;
		this.tipoPase = tipoPase;
		this.precio = precio;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoPase() {
		return tipoPase;
	}

	public void setTipoPase(String tipoPase) {
		this.tipoPase = tipoPase;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
