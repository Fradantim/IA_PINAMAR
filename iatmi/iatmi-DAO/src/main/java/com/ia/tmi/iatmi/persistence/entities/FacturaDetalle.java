package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name ="Items_Factura")
public class FacturaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_Pase", nullable = false)
	private Pase pase;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_Factura", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Factura factura;
	
	@Column(precision= 2)
	private float montoParcial;

	public FacturaDetalle() {}
	
	public FacturaDetalle(Pase pase, Factura factura) {
		this.pase = pase;
		this.factura = factura;
		this.montoParcial= pase.getPrecio();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
