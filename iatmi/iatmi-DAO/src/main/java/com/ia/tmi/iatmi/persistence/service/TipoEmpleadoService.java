package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;
import com.ia.tmi.iatmi.persistence.repository.TipoEmpleadoRepository;

@Service
public class TipoEmpleadoService {
	
	@Autowired
	private TipoEmpleadoRepository tipoEmpRepo;
	
	
	public List<TipoEmpleado> findAll(){
		return tipoEmpRepo.findAll();
	}
	
	public Optional<TipoEmpleado> findById(Integer id){
		return tipoEmpRepo.findById(id);
	}
	
	public TipoEmpleado save(TipoEmpleado tipoEmpleado){
		return tipoEmpRepo.save(tipoEmpleado);
	}
}
