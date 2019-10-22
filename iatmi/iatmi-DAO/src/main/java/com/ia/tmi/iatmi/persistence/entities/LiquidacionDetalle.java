package com.ia.tmi.iatmi.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LiquidacionDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Liquidacion liquidacion;

	@ManyToOne
	private LiquidacionItem item;

	@Column
	private Float monto;

	@ManyToOne
	private List<TipoLiquidacion> tiposLiquidaciones;

	public LiquidacionDetalle(Liquidacion liquidacion, LiquidacionItem item, Float montoReferencia) {
		this.liquidacion = liquidacion;
		this.item = item;
		monto = (item.isSueldoBasico()) ? montoReferencia : montoReferencia * item.getValor();
	}

	public LiquidacionDetalle() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Liquidacion getLiquidacion() {
		return liquidacion;
	}

	public void setLiquidacion(Liquidacion liquidacion) {
		this.liquidacion = liquidacion;
	}

	public LiquidacionItem getItem() {
		return item;
	}

	public void setItem(LiquidacionItem item) {
		this.item = item;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

}
