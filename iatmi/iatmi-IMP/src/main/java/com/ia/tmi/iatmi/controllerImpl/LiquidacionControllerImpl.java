package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.LiquidacionController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.service.LiquidacionService;
import com.ia.tmi.iatmi.transformers.PersonaTransformer;

@Controller
public class LiquidacionControllerImpl implements LiquidacionController {

	@Autowired
	public LiquidacionService liquidacionServices; 
	
	@Autowired
	private PersonaTransformer personaTransformer;
	
	@Override
	public List<PersonaDTO> findPersonaLiquidacionAnioMesAll(int anio, int mes) {
		return personaTransformer.transform(liquidacionServices.findPersonaByLiquidacionAnioMesAll(anio,mes)) ;
	}

	@Override
	public void guardarLiquidacion(int idPesona, int anio, int mes) {
		
	}

}
