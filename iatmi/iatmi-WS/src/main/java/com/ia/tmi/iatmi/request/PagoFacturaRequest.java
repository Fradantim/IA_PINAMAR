package com.ia.tmi.iatmi.request;

public class PagoFacturaRequest {
	private Integer idFactura;
	private Integer idMedioDePago;
	private String nroTarjeta;
	private String fechaVencimiento; // MM/YY
	private String codSeguridad;
	private String DNI;
		
	public PagoFacturaRequest() { }

	public PagoFacturaRequest(Integer idFactura, Integer idMedioDePago) {
		this.idFactura = idFactura;
		this.idMedioDePago = idMedioDePago;
	}

	public PagoFacturaRequest(Integer idFactura, Integer idMedioDePago, String nroTarjeta, String fechaVencimiento,
			String codSeguridad, String DNI) {
		this(idFactura,idMedioDePago);
		this.nroTarjeta = nroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.codSeguridad = codSeguridad;
		this.DNI = DNI;
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

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getCodSeguridad() {
		return codSeguridad;
	}

	public void setCodSeguridad(String codSeguridad) {
		this.codSeguridad = codSeguridad;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
}
