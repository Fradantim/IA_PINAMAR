package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.LiquidacionController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Liquidacion;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionItem;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.service.LiquidacionService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.transformers.PersonaTransformer;

@Controller
public class LiquidacionControllerImpl implements LiquidacionController {

	@Autowired
	public LiquidacionService liquidacionServices;

	@Autowired
	public PersonaService personaService;

	@Autowired
	private PersonaTransformer personaTransformer;

	@Override
	public List<PersonaDTO> findPersonaLiquidacionAnioMesAll(int anio, int mes) {
		return personaTransformer.transform(liquidacionServices.findPersonaByLiquidacionAnioMesAll(anio, mes));
	}

	
	private static final Logger logger = LoggerFactory.getLogger(LiquidacionControllerImpl.class);
	
	@Override
	public void guardarLiquidacion(int idEmpleado, int anio, int mes) {
		Optional<Persona> p = personaService.findById(idEmpleado);
		Persona persona = p.get();

		logger.info("--> Persona: " + persona.getId().toString());
		
		Liquidacion liquidacion = new Liquidacion(persona);
		for (LiquidacionItem items : persona.getTipoEmpleado().getLiquidacionItems()) {
			logger.info("--> Items Id: " + items.getId() + " Tipo Persona:  " + persona.getTipoEmpleado().getDescripcion() + " Items: " + items.getValor() + " Tipos: " + items.getTiposLiquidaciones().size());
			liquidacion.addLiquidacionItem(items);
		}
		if (persona.getTipoEmpleado().getEsMensual())
			liquidacion.cacularLiquidacionMes();
		else
			liquidacion.cacularLiquidacionPorHora(mes);
		liquidacionServices.save(liquidacion);
	}

}
