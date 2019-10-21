package com.ia.tmi.iatmi.persistence.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@OneToMany
	private List<LiquidacionDetalle> liquidacionDetalles;
	
	@Column
	private Float montoBruto;
	
	@Column
	private Float montoNeto;
	
	@ManyToOne
	private Empleado empleado;
	
	public Liquidacion(Empleado empleado) {
		this.empleado = empleado;
		fecha = new Date();
		montoNeto = 0F;
		montoBruto = 0F;
	}
	
	public Liquidacion() { }
	
	public void addLiquidacionItem(LiquidacionItem liquidacionItem) {
		if(liquidacionDetalles == null) liquidacionDetalles = new ArrayList<LiquidacionDetalle>();
		
		LiquidacionDetalle liquidacionDetalle;
		if (liquidacionItem.getValor() >= 0){			
			liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, empleado.getSueldoBasicoCostoHora());
			montoBruto+=liquidacionDetalle.getMonto();
		} else {
			liquidacionDetalle = new LiquidacionDetalle(this, liquidacionItem, montoBruto);
		}
		liquidacionDetalles.add(liquidacionDetalle);
		montoNeto+=liquidacionDetalle.getMonto();
	}
}
