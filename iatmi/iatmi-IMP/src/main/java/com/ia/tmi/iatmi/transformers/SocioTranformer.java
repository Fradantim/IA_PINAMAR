package com.ia.tmi.iatmi.transformers;

import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.dto.SocioDTO;
import com.ia.tmi.iatmi.persistence.entities.Socio;
@Component
public class SocioTranformer{

	public Socio transform(SocioDTO socioDto) {
		return   new Socio(socioDto.getNombre(), socioDto.getApellido(), socioDto.getDni(), socioDto.getEmail(), socioDto.getSexo(), socioDto.getFechaNacimiento(), socioDto.getHabilitadoDesde(), socioDto.getHabilitadoHasta());
	}
	
	public SocioDTO transform(Socio socio) {
		SocioDTO dto = new SocioDTO(socio.getNombre(), socio.getApellido(), socio.getDni(), socio.getEmail(), socio.getSexo(), socio.getFechaNacimiento(), socio.getFechaAlta(), socio.getHabilitadoDesde(), socio.getHabilitadoHasta());
		dto.setId(socio.getId());
		return dto;
	}
}
