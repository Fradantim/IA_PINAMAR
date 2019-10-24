package com.ia.tmi.iatmi.persistence.entities;

public class Pago extends Movimiento{
	
	private Factura factura;
	
	public Pago(Factura factura) {
		super(factura.getPersona(), -factura.getMontoTotal());
		this.factura=factura;
	}

	public Pago() {
	}
	
	public Factura getFactura() {
		return factura;
	}
}
