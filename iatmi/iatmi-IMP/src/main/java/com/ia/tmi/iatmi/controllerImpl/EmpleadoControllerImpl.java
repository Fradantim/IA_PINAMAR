package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.EmpleadoController;
import com.ia.tmi.iatmi.dto.EmpleadoDTO;
import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.service.EmpleadoService;

@Controller
public class EmpleadoControllerImpl implements EmpleadoController {

	@Autowired
	private EmpleadoService empleadoServices;
	
	public Empleado transform(EmpleadoDTO empleadoDto) {
		return null;
	}
	
	public EmpleadoDTO transform(Empleado empleado) {
		return null;
	}
	
	@Override
	public List<EmpleadoDTO> getAll() {
		// TODO Auto-generated method stub
		List<Empleado> empleadosEncontrados = empleadoServices.findAll();
		if(empleadosEncontrados.size()==0) 
			return new ArrayList<EmpleadoDTO>();
		else {
			List<EmpleadoDTO> empleadoDTOs = new ArrayList<EmpleadoDTO>();
			for (Empleado empleado : empleadosEncontrados) {
				empleadoDTOs.add(transform(empleado));
			}
			return empleadoDTOs;
		}
	}

	@Override
	public void setEmpleado(EmpleadoDTO dto) {
		empleadoServices.save(transform(dto));
		
	}

	@Override
	public EmpleadoDTO getEmpleadoByID(Integer lejago) {
		// TODO Auto-generated method stub
		return transform(empleadoServices.findByID(lejago));
	}

}
