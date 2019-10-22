package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.EmpleadoController;
import com.ia.tmi.iatmi.dto.EmpleadoDTO;
import com.ia.tmi.iatmi.dto.TipoEmpleadoDTO;
import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;
import com.ia.tmi.iatmi.persistence.service.EmpleadoService;
import com.ia.tmi.iatmi.transformers.EmpleadoTranformer;
import com.ia.tmi.iatmi.transformers.TipoEmpleadoTransformer;

@Controller
public class EmpleadoControllerImpl implements EmpleadoController {

	@Autowired
	private EmpleadoService empleadoServices;

	@Autowired
	private EmpleadoTranformer empleadoTranformer;
	
	@Autowired
	private TipoEmpleadoTransformer tipoEmpleadoTransformer;

	@Override
	public List<EmpleadoDTO> getAll() {
		// TODO Auto-generated method stub
		List<Empleado> empleadosEncontrados = empleadoServices.findAll();
		if (empleadosEncontrados.size() == 0)
			return new ArrayList<EmpleadoDTO>();
		else {
			List<EmpleadoDTO> empleadoDTOs = new ArrayList<EmpleadoDTO>();
			for (Empleado empleado : empleadosEncontrados) {
				empleadoDTOs.add(empleadoTranformer.transform(empleado));
			}
			return empleadoDTOs;
		}
	}

	@Override
	public void setEmpleado(EmpleadoDTO dto) {
		empleadoServices.save(empleadoTranformer.transform(dto));

	}

	@Override
	public EmpleadoDTO getEmpleadoByID(Integer lejago) {
		// TODO Auto-generated method stub
		return empleadoTranformer.transform(empleadoServices.findByID(lejago));
	}

	@Override
	public List<TipoEmpleadoDTO> getTypeAll() {
		// TODO Auto-generated method stub
		List<TipoEmpleado> tiposEmpleados = empleadoServices.findTypeAll();
		if (tiposEmpleados.size() == 0)
			return new ArrayList<TipoEmpleadoDTO>();
		else {
			List<TipoEmpleadoDTO> dtoTipos = new ArrayList<TipoEmpleadoDTO>();
			for (TipoEmpleado tipo : tiposEmpleados) {
				dtoTipos.add(tipoEmpleadoTransformer.tranform(tipo));
			}
			return dtoTipos;
		}
	}

}
