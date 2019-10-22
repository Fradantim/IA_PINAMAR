package com.ia.tmi.iatmi.controller;

import java.util.List;

import com.ia.tmi.iatmi.dto.EmpleadoDTO;
import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;

public interface EmpleadoController {

	public List<EmpleadoDTO> getAll();

	public void setEmpleado(EmpleadoDTO dto);

	public EmpleadoDTO getEmpleadoByID(Integer lejago);
	
	public List<TipoEmpleadoDTO> getTypeAll();

}
