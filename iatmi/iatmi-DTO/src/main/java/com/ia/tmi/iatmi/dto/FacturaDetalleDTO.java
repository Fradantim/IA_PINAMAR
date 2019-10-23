package com.ia.tmi.iatmi.dto;
public class FacturaDetalleDTO {

	private Integer id;
	
	private PaseDTO pase;
	
	private float montoParcial;

	public FacturaDetalleDTO() {}
	
	public FacturaDetalleDTO(PaseDTO pase) {
		this.pase = pase;
		this.montoParcial= pase.getPrecio();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaseDTO getPase() {
		return pase;
	}

	public void setPase(PaseDTO pase) {
		this.pase = pase;
	}

	public float getMontoParcial() {
		return montoParcial;
	}

	public void setMontoParcial(float montoParcial) {
		this.montoParcial = montoParcial;
	}	
}
