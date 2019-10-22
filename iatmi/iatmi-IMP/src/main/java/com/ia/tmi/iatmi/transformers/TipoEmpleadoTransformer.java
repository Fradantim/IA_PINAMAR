package com.ia.tmi.iatmi.transformers;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;

@Component
public class TipoEmpleadoTransformer {

	public TipoEmpleadoDTO tranform(TipoEmpleado bo) {
		TipoEmpleadoDTO dto =new TipoEmpleadoDTO(bo.getDescripcion(), bo.isActivo());
		dto.setId(bo.getId());
		return dto;
	}
	
	public TipoEmpleado tranform(TipoEmpleadoDTO dto) {
		TipoEmpleado bo =new TipoEmpleado(dto.getDescripcion());
		bo.setId(dto.getId());
		bo.setActivo(dto.getActivo());
		return bo;
	}
}
