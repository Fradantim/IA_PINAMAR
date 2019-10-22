package com.ia.tmi.iatmi.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Empleado;
import com.ia.tmi.iatmi.persistence.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	public List<Empleado> findAll(){
		return empleadoRepo.findAll();
	}
	
	public Empleado save(Empleado empleado) {
		return empleadoRepo.save(empleado);
	}
	
	public Empleado findByID(Integer legajo) {
		return empleadoRepo.getOne(legajo);
	}
}
