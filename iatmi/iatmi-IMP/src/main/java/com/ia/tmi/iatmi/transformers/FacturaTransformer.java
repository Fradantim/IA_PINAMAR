package com.ia.tmi.iatmi.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.FacturaDTO;
import com.ia.tmi.iatmi.persistence.entities.Factura;

@Component
public class FacturaTransformer extends Transformer<Factura, FacturaDTO>{

	@Autowired
	private FacturaDetalleTransformer factDetTransformer;
	
	@Override
	public FacturaDTO transform(Factura element) {
		FacturaDTO dto = new FacturaDTO(element.getId(), element.getTipo(), element.getMontoTotal());
		dto.setFacturaDetalles(factDetTransformer.transform(element.getFacturaDetalles()));
		return dto; 
	}
}
