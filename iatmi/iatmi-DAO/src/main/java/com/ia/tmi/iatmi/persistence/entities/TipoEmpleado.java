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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String descripcion;
		
	@Column
	private Boolean activo;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<LiquidacionItem> liquidacionItems;

	public TipoEmpleado(String descripcion) {
		this.descripcion = descripcion;
		this.activo = true;
	}
	
	public TipoEmpleado() {}

	public void addLiquidacionItem(LiquidacionItem liquidacionItem) {
		if(this.liquidacionItems == null) liquidacionItems = new ArrayList<LiquidacionItem>();
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
}