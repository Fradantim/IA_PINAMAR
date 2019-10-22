package com.ia.tmi.iatmi.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.FacturaDetalleDTO;
import com.ia.tmi.iatmi.persistence.entities.FacturaDetalle;

@Component
public class FacturaDetalleTransformer extends Transformer<FacturaDetalle, FacturaDetalleDTO>{

	@Autowired
	private PaseTransformer paseTransformer;
	
	@Override
	public FacturaDetalleDTO transform(FacturaDetalle element) {
		return new FacturaDetalleDTO(paseTransformer.transform(element.getPase()));
	}
}
