package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import com.ia.tmi.iatmi.controller.EmpleadoController;
import com.ia.tmi.iatmi.dto.EmpleadoDTO;
import com.ia.tmi.iatmi.dto.SocioDTO;
import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.entities.Socio;

public class EmpleadoControllerImpl implements EmpleadoController {

	
	public Empleado transform(EmpleadoDTO empleadoDto) {
		return null;
	}
	
	public SocioDTO transform(Socio socio) {
		SocioDTO dto = new SocioDTO(socio.getNombre(), socio.getApellido(), socio.getDni(), socio.getEmail(), socio.getSexo(), socio.getFechaNacimiento(), socio.getFechaAlta(), socio.getHabilitadoDesde(), socio.getHabilitadoHasta());
		dto.setId(socio.getId());
		return dto;
	}
	@Override
	public List<EmpleadoDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
