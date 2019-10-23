package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Descuento")
public class TipoLiquidacionDescuento extends TipoLiquidacion {

	public TipoLiquidacionDescuento(Integer id, String descripcion, Float valorPorcentaje, boolean activo,float valor) {
		super(id, descripcion, valorPorcentaje, activo);
		this.setValor(valor);
	}
	
	

	public TipoLiquidacionDescuento(String descripcion, Float valorPorcentaje, boolean activo, Float valor) {
		super(descripcion, valorPorcentaje, activo);
		this.valor = valor;
	}



	@Column
	private Float valor;

	public TipoLiquidacionDescuento() {	}

	public TipoLiquidacionDescuento(Integer id, String descripcion, Float valorPorcentaje, boolean activo) {
		super(id, descripcion, valorPorcentaje, activo);
		// TODO Auto-generated constructor stub
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

}
