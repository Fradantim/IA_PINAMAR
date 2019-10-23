package com.ia.tmi.iatmi.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Boolean esProfesor;
	
	@Column
	private Boolean esMensual;

	@ManyToMany(mappedBy = "tipoEmpleados")
	private List<LiquidacionItem> liquidacionItems;

	public TipoEmpleado(String descripcion, Boolean esProfesor, Boolean esMensual) {
		this.descripcion = descripcion;
		this.activo = true;
		this.esProfesor = esProfesor;
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

	public Boolean getEsProfesor() {
		return esProfesor;
	}

	public void setEsProfesor(Boolean esProfesor) {
		this.esProfesor = esProfesor;
	}

	public Boolean getEsMensual() {
		return esMensual;
	}

	public void setEsMensual(Boolean esMensual) {
		this.esMensual = esMensual;
	}
}
