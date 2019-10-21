package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("PAGO")
public class Pago extends Movimiento{
	
	@OneToOne
	private Factura factura;
	
	public Pago(Socio socio, Factura factura) {
		super(socio, -factura.getMontoTotal());
		this.factura=factura;
	}
	
}
