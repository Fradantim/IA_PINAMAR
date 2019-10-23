package com.ia.tmi.iatmi.transformers;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.FichaMedicaDTO;
import com.ia.tmi.iatmi.persistence.entities.FichaMedica;

@Component
public class FichaMedicaTransformerFromDTO extends Transformer<FichaMedicaDTO, FichaMedica> {

	@Override
	public FichaMedica transform(FichaMedicaDTO element) {
		return new FichaMedica(element.getNombreMedico(), element.getTelefono(), element.getObraSocial());
	}
	
	
}