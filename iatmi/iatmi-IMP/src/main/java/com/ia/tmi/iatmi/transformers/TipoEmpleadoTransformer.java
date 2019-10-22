package com.ia.tmi.iatmi.transformers;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;

@Component
public class TipoEmpleadoTransformer extends Transformer<TipoEmpleado, TipoEmpleadoDTO>{

	@Override
	public TipoEmpleadoDTO transform(TipoEmpleado element) {
		TipoEmpleadoDTO dto =new TipoEmpleadoDTO(element.getDescripcion(), element.isActivo());
		dto.setId(element.getId());
		return dto;
	}
}
