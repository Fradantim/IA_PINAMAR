package com.ia.tmi.iatmi.dto;

import java.util.ArrayList;
import java.util.List;

public class FacturaDTO extends MovimientoDTO{
	
	public FacturaDTO(Integer id, String tipo, Float monto) {
		super(id, tipo, monto);
	}

	private List<FacturaDetalleDTO> facturaDetalles;
	
	public void addFacturaDetalle(FacturaDetalleDTO facturaDetalle) {
		if (facturaDetalles == null) facturaDetalles = new ArrayList<FacturaDetalleDTO>();
		facturaDetalles.add(facturaDetalle);
		monto+=facturaDetalle.getMontoParcial();
	}
	
	public List<FacturaDetalleDTO> getFacturaDetalles() {
		return facturaDetalles;
	}

	public void setFacturaDetalles(List<FacturaDetalleDTO> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}
}
