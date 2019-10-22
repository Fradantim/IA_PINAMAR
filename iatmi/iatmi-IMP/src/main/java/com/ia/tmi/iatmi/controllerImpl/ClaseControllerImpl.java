package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.ClaseController;
import com.ia.tmi.iatmi.dto.ClaseDTO;
import com.ia.tmi.iatmi.persistence.service.ClaseService;
import com.ia.tmi.iatmi.transformers.ClaseTransformer;

@Controller
public class ClaseControllerImpl implements ClaseController{

	@Autowired
	private ClaseService claseService;
	
	@Autowired
	private ClaseTransformer claseTransformer;
	
	@Override
	public List<ClaseDTO> findAll() {
		return claseTransformer.transform(claseService.findAll());
	}	
}
