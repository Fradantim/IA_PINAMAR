package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "Descuento")
public class TipoLiquidacionDescuento extends TipoLiquidacion {

	@Column
	private Float valor;

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
