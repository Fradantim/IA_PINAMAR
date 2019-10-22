package com.ia.tmi.iatmi.dto;

public class TipoEmpleadoDTO {

	private Integer id;

	private String descripcion;

	private Boolean activo;

	
	public TipoEmpleadoDTO( String descripcion, Boolean activo) {
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}
