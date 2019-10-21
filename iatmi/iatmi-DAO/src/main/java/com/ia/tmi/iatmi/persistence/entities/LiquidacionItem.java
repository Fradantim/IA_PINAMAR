package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LiquidacionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descripcion;
	
	@Column
	private Float valor;
	
	@Column
	private Boolean activo;
	
	@Column
	private Boolean sueldoBasico;

	public LiquidacionItem(String descripcion, Float valor, Boolean sueldoBasico) {
		this.descripcion = descripcion;
		this.valor = valor;
		this.sueldoBasico = sueldoBasico;
		this.activo = true;
	}
	
	public LiquidacionItem() { }

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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Boolean isActivo() {
		return activo;
	}
	
	public Boolean isSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(Boolean sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
}
