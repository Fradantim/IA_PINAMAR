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
	private Date habilitadoDesde;
	
	@Column
	private Date habilitadoHasta;
	
	public Socio() {}
	
	public Socio(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			int nroSocio, Date habilitadoDesde, Date habilitadoHasta) {
		super(nombre, apellido, dni, email, sexo, fechaNacimiento);
		this.nroSocio = nroSocio;
		this.habilitadoDesde = habilitadoDesde;
		this.habilitadoHasta = habilitadoHasta;
	}

	public int getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
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
