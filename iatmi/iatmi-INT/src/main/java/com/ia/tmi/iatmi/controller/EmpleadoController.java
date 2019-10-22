package com.ia.tmi.iatmi.controller;

import java.util.List;

import com.ia.tmi.iatmi.dto.EmpleadoDTO;

public interface EmpleadoController {

	public List<EmpleadoDTO> getAll();

	public void setEmpleado(EmpleadoDTO dto);

	public EmpleadoDTO getEmpleadoByID(Integer lejago);

}
