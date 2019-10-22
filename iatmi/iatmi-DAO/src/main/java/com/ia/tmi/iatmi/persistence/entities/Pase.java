package com.ia.tmi.iatmi.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pase {	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
	private TipoPase tipoPase;
	
	@Column(nullable = false, scale = 2)
	private Float precio;
	
	@Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
	private Estado estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPase getTipoPase() {
		return tipoPase;
	}

	public void setTipoPase(TipoPase tipoPase) {
		this.tipoPase = tipoPase;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pase() {
	}
	
	
	
}
