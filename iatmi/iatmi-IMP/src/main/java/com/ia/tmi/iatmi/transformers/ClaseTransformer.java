package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.ClaseDTO;
import com.ia.tmi.iatmi.persistence.entities.Clase;

@Component
public class ClaseTransformer {
	
	public ClaseDTO transform(Clase clase) {
		return new ClaseDTO(clase.getId(), clase.getNombre());
	}
	
	public List<ClaseDTO> transform(List<Clase> clases) {
		return clases.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}