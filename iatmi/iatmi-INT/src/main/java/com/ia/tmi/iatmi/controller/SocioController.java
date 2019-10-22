package com.ia.tmi.iatmi.controller;

import java.util.List;

import com.ia.tmi.iatmi.dto.SocioDTO;

public interface SocioController {

	public List<SocioDTO> getAll();
	
	public void setSocio(SocioDTO dto);
	
	public SocioDTO getSocioByID(Integer nroSocio);
	
}
