package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.MedioDePagoDTO;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;

@Component
public class MedioDePagoTransformer {
	
	public MedioDePagoDTO transform(MedioDePago medioDePago) {
		return new MedioDePagoDTO(medioDePago.getId(), medioDePago.getNombre(), medioDePago.getEsTarjeta());
	}
	
	public List<MedioDePagoDTO> transform(List<MedioDePago> mediosDePago) {
		return mediosDePago.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}