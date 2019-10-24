package com.ia.tmi.iatmi.controller;

import java.util.List;

import com.ia.tmi.iatmi.dto.PersonaDTO;

public interface LiquidacionController {

	public List<PersonaDTO> findPersonaLiquidacionAnioMesAll(int anio, int mes);
	
	public void guardarLiquidacion(int idPesona,int anio, int mes);
	
	public void depositarLiquidaciones(int anio, int mes);
	
	public List<PersonaDTO> getPersonasAPagar(int anio, int mes);
}
