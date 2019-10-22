package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.MedioDePagoController;
import com.ia.tmi.iatmi.dto.MedioDePagoDTO;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;
import com.ia.tmi.iatmi.transformers.MedioDePagoTransformer;

@Controller
public class MedioDePagoControllerImpl implements MedioDePagoController{

	@Autowired
	private MedioDePagoService mdpService;
	
	@Autowired
	private MedioDePagoTransformer mdpTransformer;
	
	@Override
	public List<MedioDePagoDTO> findAll() {
		return mdpTransformer.transform(mdpService.findAll());
	}	
}
