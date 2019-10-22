package com.ia.tmi.iatmi.persistence.entities;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Habilitacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@OneToOne
	private Persona persona;
	
	@ManyToOne
	private Pase pase;
	
	@Column
	private Date habilitadoDesde;

	@Column
	private Date habilitadoHasta;
	
	public Habilitacion() {}

	public Habilitacion(Persona persona, Pase pase) {
		this.persona=persona;
		this.habilitadoDesde=new Date();
		LocalDateTime tomorrow = LocalDateTime.now().plusDays(pase.getCantidadDias()); 
		this.habilitadoHasta = Date.from(tomorrow.atZone(ZoneId.systemDefault()).toInstant());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Pase getPase() {
		return pase;
	}

	public void setPase(Pase pase) {
		this.pase = pase;
	}

	public Date getHabilitadoDesde() {
		return habilitadoDesde;
	}

	public void setHabilitadoDesde(Date habilitadoDesde) {
		this.habilitadoDesde = habilitadoDesde;
	}

	public Date getHabilitadoHasta() {
		return habilitadoHasta;
	}

	public void setHabilitadoHasta(Date habilitadoHasta) {
		this.habilitadoHasta = habilitadoHasta;
	}	
}
