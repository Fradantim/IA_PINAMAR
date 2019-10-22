package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.SocioController;
import com.ia.tmi.iatmi.dto.SocioDTO;
import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.service.SocioService;
import com.ia.tmi.iatmi.transformers.SocioTranformer;

@Controller
public class SocioControllerImpl implements SocioController {

	@Autowired
	private SocioService socioServices;

	@Autowired
	private SocioTranformer socioTranformer;
	
	
	@Override
	public List<SocioDTO> getAll() {
		List<Socio> sociosEncontrados = socioServices.findAll();
		if(sociosEncontrados.size()==0) 
			return new ArrayList<SocioDTO>();
		else {
			List<SocioDTO> socioDTOs = new ArrayList<SocioDTO>();
			for (Socio socio : sociosEncontrados) {
				socioDTOs.add(socioTranformer.transform(socio));
			}
			return socioDTOs;
		}
	}

	@Override
	public void setSocio(SocioDTO dto) {
		//@TODO validar los atributos nulos.
		socioServices.save(socioTranformer.transform(dto));
		
	}

	@Override
	public SocioDTO getSocioByID(Integer nroSocio) {
		return  socioTranformer.transform(socioServices.findByID(nroSocio));
		
	}

}
