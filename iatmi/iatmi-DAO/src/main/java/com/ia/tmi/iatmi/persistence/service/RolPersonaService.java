package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.repository.RolPersonaRepository;

@Service
public class RolPersonaService {
	
	@Autowired
	private RolPersonaRepository rolRepo;
	
	
	public List<RolPersona> findAll(){
		return rolRepo.findAll();
	}
	
	public Optional<RolPersona> findById(String id){
		return rolRepo.findById(id);
	}
	
	public RolPersona save(RolPersona rol){
		return rolRepo.save(rol);
	}
}
