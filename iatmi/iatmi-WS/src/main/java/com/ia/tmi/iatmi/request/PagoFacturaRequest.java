package com.ia.tmi.iatmi.request;

public class PagoFacturaRequest {
	private Integer idFactura;
	private Integer idMedioDePago;
	
	public PagoFacturaRequest() { }

	public PagoFacturaRequest(Integer idFactura, Integer idMedioDePago) {
		this.idFactura = idFactura;
		this.idMedioDePago = idMedioDePago;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getIdMedioDePago() {
		return idMedioDePago;
	}

	public void setIdMedioDePago(Integer idMedioDePago) {
		this.idMedioDePago = idMedioDePago;
	}
}
