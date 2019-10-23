package com.ia.tmi.iatmi.controller;

import java.util.List;

import com.ia.tmi.iatmi.dto.MovimientoDTO;

public interface MovimientoController {
	public List<MovimientoDTO> findAll();
	
	public List<MovimientoDTO> findBySocio(Integer idSocio);
	
	public void pagarFactura(Integer idFactura, Integer idMedioDePago, String nroTarjeta, String fechaVencimiento, String codSeguridad, String DNI);
	
	public void pagarFactura(Integer idFactura, Integer idMedioDePago);
}
