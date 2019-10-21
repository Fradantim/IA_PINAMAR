package com.ia.tmi.iatmi.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
//@DiscriminatorValue("socio")
public class Socio extends Persona {

	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int nroSocio;
	
	@Column
	private Date fechaAltaSocio;
	
	@Column
	private Date habilitadoDesde;
	
	@Column
	private Date habilitadoHasta;

	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}

	public Date getFechaAltaSocio() {
		return fechaAltaSocio;
	}

	public void setFechaAltaSocio(Date fechaAltaSocio) {
		this.fechaAltaSocio = fechaAltaSocio;
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
