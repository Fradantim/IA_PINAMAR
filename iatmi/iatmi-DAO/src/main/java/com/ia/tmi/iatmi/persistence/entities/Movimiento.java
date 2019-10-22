package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO")
public abstract class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private Date fecha;
	
	@Column(name = "TIPO", insertable = false, updatable = false)
	private String tipo;

	@Column(precision=2)
	protected Float montoTotal;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "nroSocio", nullable = false)
	private Habilitacion socio;

	public Movimiento() {}
	
	public Movimiento(Habilitacion socio, Float montoTotal) {
		this.fecha = new Date();
		this.socio = socio;
		this.montoTotal=montoTotal;
	}
	
	public Movimiento(Habilitacion socio) {
		this(socio, 0F);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Habilitacion getSocio() {
		return socio;
	}

	public void setSocio(Habilitacion socio) {
		this.socio = socio;
	}
	
	public String getTipo() {
		return tipo;
	}
}
