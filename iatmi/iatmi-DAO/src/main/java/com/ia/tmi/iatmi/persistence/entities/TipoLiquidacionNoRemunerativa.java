package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "NoRemunerativa")
public class TipoLiquidacionNoRemunerativa extends TipoLiquidacion {

	public TipoLiquidacionNoRemunerativa(Integer id, String descripcion, Float valorPorcentaje, boolean activo,
			float valor) {
		super(id, descripcion, valorPorcentaje, activo);
		this.setValor(valor);
	}

	
	public TipoLiquidacionNoRemunerativa(String descripcion, Float valorPorcentaje, boolean activo, Float valor) {
		super(descripcion, valorPorcentaje, activo);
		this.valor = valor;
	}


	@Column
	private Float valor;

	
	public TipoLiquidacionNoRemunerativa() {}

	

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
}
