package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.PaseDTO;
import com.ia.tmi.iatmi.persistence.entities.Pase;

@Component
public class PaseTransformer {
	
	public PaseDTO transform(Pase pase) {
		return new PaseDTO(pase.getId(), pase.getPrecio(), pase.getNombre());
	}
	
	public List<PaseDTO> transform(List<Pase> pases) {
		return pases.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}