package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.SocioController;
import com.ia.tmi.iatmi.dto.SocioDTO;
import com.ia.tmi.iatmi.persistence.service.SocioService;

@Controller
public class SocioControllerImpl implements SocioController {

	@Autowired
	private SocioService socioServices;

	
	@Override
	public List<SocioDTO> getAll() {
		//TODO sacar metodo
		/*List<Habilitacion> sociosEncontrados = socioServices.findAll();
		if(sociosEncontrados.size()==0) 
			return new ArrayList<SocioDTO>();
		else {
			List<SocioDTO> socioDTOs = new ArrayList<SocioDTO>();
			for (Habilitacion socio : sociosEncontrados) {
				socioDTOs.add(socioTranformer.transform(socio));
			}
			return socioDTOs;
		}*/
		return null;
	}

	@Override
	public void setSocio(SocioDTO dto) {
		// TODO ver donde poner el insert de SOCIO
		//socioServices.save(socioTranformer.transform(dto));
	}

	@Override
	public SocioDTO getSocioByID(Integer nroSocio) {
		/// TODO ver hace falta esto?
		//return  socioTranformer.transform(socioServices.findByID(nroSocio));
		return null;
		
	}

}
