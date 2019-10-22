package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.SocioController;
import com.ia.tmi.iatmi.dto.SocioDTO;
import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.service.SocioService;

@Controller
public class SocioControllerImpl implements SocioController {

	@Autowired
	private SocioService socioServices;

	public Socio transform(SocioDTO socioDto) {
		return   new Socio(socioDto.getNombre(), socioDto.getApellido(), socioDto.getDni(), socioDto.getEmail(), socioDto.getSexo(), socioDto.getFechaNacimiento(), socioDto.getHabilitadoDesde(), socioDto.getHabilitadoHasta());
	}
	
	public SocioDTO transform(Socio socio) {
		SocioDTO dto = new SocioDTO(socio.getNombre(), socio.getApellido(), socio.getDni(), socio.getEmail(), socio.getSexo(), socio.getFechaNacimiento(), socio.getFechaAlta(), socio.getHabilitadoDesde(), socio.getHabilitadoHasta());
		dto.setId(socio.getId());
		return dto;
	}
	
	
	@Override
	public List<SocioDTO> getAll() {
		List<Socio> sociosEncontrados = socioServices.findAll();
		if(sociosEncontrados.size()==0) 
			return new ArrayList<SocioDTO>();
		else {
			List<SocioDTO> socioDTOs = new ArrayList<SocioDTO>();
			for (Socio socio : sociosEncontrados) {
				socioDTOs.add(transform(socio));
			}
			return socioDTOs;
		}
	}

	@Override
	public void setSocio(SocioDTO dto) {
		//@TODO validar los atributos nulos.
		socioServices.save(transform(dto));
		
	}

	@Override
	public SocioDTO getSocioByID(Integer nroSocio) {
		return  transform(socioServices.findByID(nroSocio));
		
	}

}
