package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.TipoEmpleadoController;
import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;
import com.ia.tmi.iatmi.persistence.service.TipoEmpleadoService;
import com.ia.tmi.iatmi.transformers.TipoEmpleadoTransformer;

@Controller
public class TipoEmpleadoControllerImpl implements TipoEmpleadoController{

	@Autowired
	private TipoEmpleadoService tipEmpService;
	
	@Autowired
	private TipoEmpleadoTransformer tipoEmpTransformer;

	@Override
	public List<TipoEmpleadoDTO> findAll() {
		return tipoEmpTransformer.transform(tipEmpService.findAll());
	}	
}
