package com.ia.tmi.iatmi.transformers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.MovimientoDTO;
import com.ia.tmi.iatmi.persistence.entities.Movimiento;

@Component
public class MovimientoTransformer {
	
	public MovimientoDTO transform(Movimiento movimiento) {
		return new MovimientoDTO(movimiento.getId(), movimiento.getTipo(), movimiento.getMontoTotal());
	}
	
	public List<MovimientoDTO> transform(List<? extends Movimiento> movimientos) {
		return movimientos.stream().map(m -> transform(m)).collect(Collectors.toList());
	}
}
