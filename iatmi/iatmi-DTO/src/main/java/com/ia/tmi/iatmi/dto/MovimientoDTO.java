package com.ia.tmi.iatmi.dto;

public class MovimientoDTO {
	
	private Integer id;
	
	private String tipo;
	
	protected Float monto;

	public MovimientoDTO(Integer id, String tipo, Float monto) {
		this.id = id;
		this.tipo = tipo;
		this.monto = monto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
