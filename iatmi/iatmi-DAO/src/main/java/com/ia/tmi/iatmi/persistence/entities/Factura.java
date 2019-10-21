package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

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

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Date fechaAlta;

	@Column(precision=2)
	private  float montoTotal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nroSocio", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Socio socio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
