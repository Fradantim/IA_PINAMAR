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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Liquidacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Date fecha;

	@Column
	private Date fechaPago;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
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
		this.setEmpleado(empleado);
		setFecha(new Date());
		setMontoNeto(0F);
		setMontoBruto(0F);
		montoDescuento = 0F;
		montoNoRemunarativo = 0F;
		setFechaPago(null);
	}

	private static final Logger logger = LoggerFactory.getLogger(Liquidacion.class);

	public Liquidacion() {
	}

	public void addLiquidacionItem(LiquidacionItem liquidacionItem) {
		if (getLiquidacionDetalles() == null)
			setLiquidacionDetalles(new ArrayList<LiquidacionDetalle>());

		LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, getMontoBruto());
		getLiquidacionDetalles().add(liquidacionDetalle);
	}

	public void cacularLiquidacionMes() {

		setMontoBruto(getMontoBruto() + getEmpleado().getSueldoBasicoCostoHora());
		logger.info("--> monto bruto empleado: " + getMontoBruto() + " Id empleado: " + getEmpleado().getId());
		logger.info("--> Cantidad de detalles: " + getLiquidacionDetalles().size());
		for (LiquidacionDetalle liquidacionDetalle : getLiquidacionDetalles()) {
			logger.info("--> items del detalle: " + liquidacionDetalle.toString());
			setMontoBruto(getMontoBruto() + liquidacionDetalle.getItem().calcularRemunerativo());
		}
		for (LiquidacionDetalle liquidacionDetalle : getLiquidacionDetalles()) {
			logger.info("--> items del detalle: " + liquidacionDetalle.getItem().getDescripcion() + " Valor: "
					+ liquidacionDetalle.getItem().getValor());
			montoNoRemunarativo +=  liquidacionDetalle.getItem().calcularNoRemunerativo();
		}
		for (LiquidacionDetalle liquidacionDetalle : getLiquidacionDetalles()) {
			logger.info("--> items del detalle: " + liquidacionDetalle.getItem().getDescripcion() + " Valor: "
					+ liquidacionDetalle.getItem().getValor() + " Valor  "
					+ liquidacionDetalle.getItem().getTiposLiquidaciones().size());
			montoDescuento += liquidacionDetalle.getItem().calcularDescuento(getMontoBruto());
		}

		logger.info("--> montoBruto: " + getMontoBruto());
		logger.info("--> montoNoRemunarativo: " + montoNoRemunarativo);
		logger.info("--> montoDescuento: " + montoDescuento);
		setMontoNeto(getMontoBruto() + montoNoRemunarativo - montoDescuento);
		logger.info("--> montoNeto: " + getMontoNeto());
	}

	public void cacularLiquidacionPorHora(int mes) {
		int horas = getEmpleado().calcularHorasPorFichada(mes);
		if (getLiquidacionDetalles() != null)
			for (LiquidacionDetalle liquidacionDetalle : getLiquidacionDetalles())
				setMontoBruto(horas * liquidacionDetalle.getItem().calcularRemunerativo());
		else if (this.getEmpleado() != null)
			setMontoBruto(getEmpleado().getSueldoBasicoCostoHora());
	}

	public Float getMontoDescuento() {
		return montoDescuento;
	}

	public void setMontoDescuento(Float montoDescuento) {
		this.montoDescuento = montoDescuento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getMontoNeto() {
		return montoNeto;
	}

	public void setMontoNeto(Float montoNeto) {
		this.montoNeto = montoNeto;
	}

	public Persona getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Persona empleado) {
		this.empleado = empleado;
	}

	public List<LiquidacionDetalle> getLiquidacionDetalles() {
		return liquidacionDetalles;
	}

	public void setLiquidacionDetalles(List<LiquidacionDetalle> liquidacionDetalles) {
		this.liquidacionDetalles = liquidacionDetalles;
	}

	public Float getMontoBruto() {
		return montoBruto;
	}

	public void setMontoBruto(Float montoBruto) {
		this.montoBruto = montoBruto;
	}
}
