package com.ia.tmi.iatmi.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class TipoEmpleado {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) a mano
	private Integer id;

	@Column
	private String descripcion;

	@Column
	private Boolean activo;

	@Column
	private Boolean esProfresor;
	
	@Column
	private Boolean esMensual;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<LiquidacionItem> liquidacionItems;

	public TipoEmpleado(String descripcion, Boolean esProfresor, Boolean esMensual) {
		this.descripcion = descripcion;
		this.activo = true;
		this.esProfresor = esProfresor;
		this.esMensual = esMensual;
	}

	public TipoEmpleado() {
	}

	public void addLiquidacionItem(LiquidacionItem liquidacionItem) {
		if (this.liquidacionItems == null)
			liquidacionItems = new ArrayList<LiquidacionItem>();
		liquidacionItems.add(liquidacionItem);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean isActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<LiquidacionItem> getLiquidacionItems() {
		return liquidacionItems;
	}

	public void setLiquidacionItems(List<LiquidacionItem> liquidacionItems) {
		this.liquidacionItems = liquidacionItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEsProfresor() {
		return esProfresor;
	}

	public void setEsProfresor(Boolean esProfresor) {
		this.esProfresor = esProfresor;
	}

	public Boolean getEsMensual() {
		return esMensual;
	}

	public void setEsMensual(Boolean esMensual) {
		this.esMensual = esMensual;
	}
}
