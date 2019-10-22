package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("PAGO")
public class Pago extends Movimiento{
	
	@OneToOne
	private Factura factura;
	
	@ManyToOne
	private MedioDePago medioDePago;
	
	public Pago(Factura factura, MedioDePago medioDePago) {
		super(factura.getSocio(), -factura.getMontoTotal());
		this.factura=factura;
		this.medioDePago = medioDePago;
	}
}
