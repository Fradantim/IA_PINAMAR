package com.ia.tmi.iatmi.persistence.entities;

public class FacturaDetalle {

	private Integer id;
	
	private Pase pase;
	
	private Factura factura;
	
	private float montoParcial;

	public FacturaDetalle() {}
	
	public FacturaDetalle(Pase pase, Factura factura) {
		this.pase = pase;
		this.factura = factura;
		this.montoParcial= pase.getPrecio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pase getPase() {
		return pase;
	}

	public void setPase(Pase pase) {
		this.pase = pase;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public float getMontoParcial() {
		return montoParcial;
	}

	public void setMontoParcial(float montoParcial) {
		this.montoParcial = montoParcial;
	}	
}
