package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo_liquidacion")
public abstract class TipoLiquidacion {

	@Id
	//@GeneratedValue
	private Integer id;
	
	@Column
	private String descripcion;
	
	
	@Column
	private Float valorPorcentaje;
	
	@Column
	private boolean activo;

	@ManyToOne
	protected LiquidacionItem liquidacionItem;
	
	public TipoLiquidacion(Integer id, String descripcion, Float valorPorcentaje, boolean activo) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.valorPorcentaje = valorPorcentaje;
		this.activo = activo;
	}

	public TipoLiquidacion( String descripcion, Float valorPorcentaje, boolean activo) {
		super();
		this.descripcion = descripcion;
		this.valorPorcentaje = valorPorcentaje;
		this.activo = activo;
	}
	
	public TipoLiquidacion(String descripcion, Float valorPorcentaje, boolean activo, LiquidacionItem liquidacionItem) {
		super();
		this.descripcion = descripcion;
		this.valorPorcentaje = valorPorcentaje;
		this.activo = activo;
		this.liquidacionItem = liquidacionItem;
	}

	public TipoLiquidacion() {	}


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

	public Float getValorPorcentaje() {
		return valorPorcentaje;
	}

	public void setValorPorcentaje(Float valorPorcentaje) {
		this.valorPorcentaje = valorPorcentaje;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public LiquidacionItem getLiquidacionItem() {
		return liquidacionItem;
	}

	public void setLiquidacionItem(LiquidacionItem liquidacionItem) {
		this.liquidacionItem = liquidacionItem;
	}
	
	
	
}
