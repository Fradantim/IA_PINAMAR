package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.PaseController;
import com.ia.tmi.iatmi.dto.PaseDTO;
import com.ia.tmi.iatmi.persistence.service.PaseService;
import com.ia.tmi.iatmi.transformers.PaseTransformer;

@Controller
public class PaseControllerImpl implements PaseController{

	@Autowired
	private PaseService paseService;
	
	@Autowired
	private PaseTransformer paseTransformer;
	
	@Override
	public List<PaseDTO> findAll() {
		return paseTransformer.transform(paseService.findAll());
	}	
}
