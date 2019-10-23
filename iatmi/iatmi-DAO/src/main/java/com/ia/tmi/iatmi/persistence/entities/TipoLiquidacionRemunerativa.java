package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Remunerativa")
public class TipoLiquidacionRemunerativa extends TipoLiquidacion {

	public TipoLiquidacionRemunerativa(Integer id, String descripcion, Float valorPorcentaje, boolean activo,
			float valor) {
		super(id, descripcion, valorPorcentaje, activo);
		this.setValor(valor);
	}
	
	public TipoLiquidacionRemunerativa(Integer id, String descripcion, Float valorPorcentaje, boolean activo,
			float valor, LiquidacionItem item) {
		this(id,descripcion, valorPorcentaje, activo, valor);
		this.liquidacionItem= item;
	}

	public TipoLiquidacionRemunerativa(String descripcion, Float valorPorcentaje, boolean activo,
			float valor) {
		super(descripcion, valorPorcentaje, activo);
		this.setValor(valor);
	}
	
	public TipoLiquidacionRemunerativa() {	}


	@Column
	private Float valor;

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}
