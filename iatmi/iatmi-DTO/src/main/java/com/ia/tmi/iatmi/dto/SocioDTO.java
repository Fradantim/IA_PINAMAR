package com.ia.tmi.iatmi.dto;

import java.util.Date;

public class SocioDTO extends PersonaDTO {

	private Integer nroSocio;
	
	private Date habilitadoDesde;
	
	private Date habilitadoHasta;
	
	public SocioDTO(String nombre, String apellido, String dni, String email, String sexo, Date fechaNacimiento,
			Date fechaAlta, Date habilitadoDesde, Date habilitadoHasta) {
		super(nombre, apellido, dni, email, sexo, fechaNacimiento, fechaAlta);
		this.habilitadoDesde = habilitadoDesde;
		this.habilitadoHasta = habilitadoHasta;
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

	public Integer getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(Integer nroSocio) {
		this.nroSocio = nroSocio;
	}

}
