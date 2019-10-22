package com.ia.tmi.iatmi.transformers;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.EmpleadoDTO;
import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;
import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;

@Component
public class EmpleadoTranformer {

	public Empleado transform(EmpleadoDTO dto) {
		TipoEmpleado tipoEmpleado = new TipoEmpleado((dto.getTipoEmpleado()== null)?"":dto.getTipoEmpleado().getDescripcion());
		return new Empleado(dto.getNombre(), dto.getApellido(), dto.getDni(), dto.getEmail(), dto.getSexo(), dto.getFechaNacimiento(), dto.getLegajo(), tipoEmpleado, dto.getSueldoBasicoCostoHora());
	}
	
	public EmpleadoDTO transform(Empleado bo) {
		TipoEmpleadoDTO dtoTipo = new TipoEmpleadoDTO(bo.getTipoEmpleado().getDescripcion(), bo.getTipoEmpleado().isActivo());
		EmpleadoDTO dto = new EmpleadoDTO(bo.getNombre(),bo.getApellido(), bo.getDni(), bo.getEmail(), bo.getSexo(), bo.getFechaNacimiento(), bo.getFechaAlta(),bo.getSueldoBasicoCostoHora(), dtoTipo);
		dto.setId(bo.getId());
		dto.setLegajo(bo.getLegajo());
		return dto;
	}
}
