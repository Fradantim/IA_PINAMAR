package com.ia.tmi.iatmi.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;
import com.ia.tmi.iatmi.persistence.repository.EmpleadoRepository;
import com.ia.tmi.iatmi.persistence.repository.TipoEmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Autowired
	private TipoEmpleadoRepository tipoEmpleadoRepo;
	
	public List<Empleado> findAll(){
		return empleadoRepo.findAll();
	}
	
	public Empleado save(Empleado empleado) {
		return empleadoRepo.save(empleado);
	}
	
	public Empleado findByID(Integer legajo) {
		return empleadoRepo.getOne(legajo);
	}
	
	public List<TipoEmpleado> findTypeAll(){
		return tipoEmpleadoRepo.findAll();
	}
}
