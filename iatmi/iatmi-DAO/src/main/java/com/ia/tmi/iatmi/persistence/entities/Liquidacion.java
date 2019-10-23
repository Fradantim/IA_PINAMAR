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
		setFecha(new Date());
		montoNeto = 0F;
		montoBruto = 0F;
		montoDescuento = 0F;
		montoNoRemunarativo = 0F;
	}

	private static final Logger logger = LoggerFactory.getLogger(Liquidacion.class);
	
	public Liquidacion() {
	}

	public void addLiquidacionItem(LiquidacionItem liquidacionItem) {
		if (liquidacionDetalles == null)
			liquidacionDetalles = new ArrayList<LiquidacionDetalle>();

		LiquidacionDetalle liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, montoBruto);
		
//		if (liquidacionItem.getValor() >= 0) {
//			liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, empleado.getSueldoBasicoCostoHora());
//			montoBruto += liquidacionDetalle.getMonto();
//		} else {
//			liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, montoBruto);
//		}
//		montoNeto += liquidacionDetalle.getMonto(); +  
		
		liquidacionDetalles.add(liquidacionDetalle);
	}

	public void cacularLiquidacionMes() {

		montoBruto = montoBruto + empleado.getSueldoBasicoCostoHora();
		logger.info("--> monto bruto empleado: " + montoBruto + " Id empleado: " + empleado.getId());
		logger.info("--> Cantidad de detalles: " + liquidacionDetalles.size());
		for (LiquidacionDetalle liquidacionDetalle : liquidacionDetalles) {
			logger.info("--> items del detalle: " + liquidacionDetalle.toString());			
			liquidacionDetalle.setMonto(liquidacionDetalle.getItem().calcularRemunerativo());
			montoBruto = montoBruto + liquidacionDetalle.getItem().calcularRemunerativo();
		}
		for (LiquidacionDetalle liquidacionDetalle : liquidacionDetalles) {
			logger.info("--> items del detalle: " + liquidacionDetalle.getItem().getDescripcion() + " Valor: "+ liquidacionDetalle.getItem().getValor() );			
			liquidacionDetalle.setMonto(liquidacionDetalle.getItem().calcularNoRemunerativo());
			montoNoRemunarativo = liquidacionDetalle.getItem().calcularNoRemunerativo();
		}
		for (LiquidacionDetalle liquidacionDetalle : liquidacionDetalles) {
			logger.info("--> items del detalle: " + liquidacionDetalle.getItem().getDescripcion() + " Valor: "+ liquidacionDetalle.getItem().getValor() + " Valor  " + liquidacionDetalle.getItem().getTiposLiquidaciones().size());			
			liquidacionDetalle.setMonto(liquidacionDetalle.getItem().calcularDescuento(montoBruto));
			montoDescuento = liquidacionDetalle.getItem().calcularDescuento(montoBruto);
		}

		montoNeto = montoBruto + montoNoRemunarativo - montoDescuento;
		
		logger.info("--> montoBruto: " + montoBruto);
		logger.info("--> montoNoRemunarativo: " + montoNoRemunarativo);
		logger.info("--> montoDescuento: " + montoDescuento);
		logger.info("--> montoNeto: " + montoNeto);
	}

	public void cacularLiquidacionPorHora(int mes) {
		int	horas = empleado.calcularHorasPorFichada(mes);
		if(liquidacionDetalles != null) 
			for (LiquidacionDetalle liquidacionDetalle : liquidacionDetalles) 
				montoBruto = horas * liquidacionDetalle.getItem().calcularRemunerativo();
		else if(this.empleado != null) 
			montoBruto = empleado.getSueldoBasicoCostoHora();
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
}
