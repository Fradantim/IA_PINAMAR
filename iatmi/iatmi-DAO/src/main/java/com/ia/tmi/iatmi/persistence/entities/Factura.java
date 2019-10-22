package com.ia.tmi.iatmi.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("FACTURA")
public class Factura extends Movimiento{
	
	@OneToMany
	private List<FacturaDetalle> facturaDetalles;
	
	public void addFacturaDetalle(FacturaDetalle facturaDetalle) {
		if (facturaDetalles == null) facturaDetalles = new ArrayList<FacturaDetalle>();
		facturaDetalles.add(facturaDetalle);
		montoTotal+=facturaDetalle.getMontoParcial();
	}
	
	public Factura(Persona socio) {
		super(socio);
	}
	
	public List<FacturaDetalle> getFacturaDetalles() {
		return facturaDetalles;
	}

	public void setFacturaDetalles(List<FacturaDetalle> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}
}
