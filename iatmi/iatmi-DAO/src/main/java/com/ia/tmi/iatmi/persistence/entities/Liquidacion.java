package com.ia.tmi.iatmi.persistence.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Liquidacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Date fecha;

	@OneToMany(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	private List<LiquidacionDetalle> liquidacionDetalles;

	@Column
	private Float montoBruto;

	@Column
	private Float montoNeto;

	@Column
	private Float montoDescuento;

	@Column
	private Float montoNoRemunarativo;

	@ManyToOne
	private Persona empleado;

	public Liquidacion(Persona empleado) {
		this.empleado = empleado;
		fecha = new Date();
		montoNeto = 0F;
		montoBruto = 0F;
		montoDescuento = 0F;
		montoNoRemunarativo = 0F;
	}

	public Liquidacion() {
	}

	public void addLiquidacionItem(LiquidacionItem liquidacionItem) {
		if (liquidacionDetalles == null)
			liquidacionDetalles = new ArrayList<LiquidacionDetalle>();

		LiquidacionDetalle liquidacionDetalle;
		if (liquidacionItem.getValor() >= 0) {
			liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, empleado.getSueldoBasicoCostoHora());
			montoBruto += liquidacionDetalle.getMonto();
		} else {
			liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, montoBruto);
		}
		liquidacionDetalles.add(liquidacionDetalle);
		montoNeto += liquidacionDetalle.getMonto();
	}

	public void cacularLiquidacionMes() {

		montoBruto = montoBruto + empleado.getSueldoBasicoCostoHora();
		for (LiquidacionDetalle liquidacionDetalle : liquidacionDetalles) {
			montoBruto = liquidacionDetalle.getItem().calcularRemunerativo();
			montoNoRemunarativo = liquidacionDetalle.getItem().calcularNoRemunerativo();
			montoDescuento = liquidacionDetalle.getItem().calcularDescuento(montoBruto);
		}
		montoNeto = montoBruto + montoNoRemunarativo - montoDescuento;
	}

	public void cacularLiquidacionPorHora(int mes) {
		int	horas = empleado.calcularHorasPorFichada(mes);
		for (LiquidacionDetalle liquidacionDetalle : liquidacionDetalles) {
			montoBruto = horas * liquidacionDetalle.getItem().calcularRemunerativo();
		}
	}

	public Float getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(Float montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
}
