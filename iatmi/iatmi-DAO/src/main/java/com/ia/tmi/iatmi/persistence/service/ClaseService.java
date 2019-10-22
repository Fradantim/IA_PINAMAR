package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.repository.ClaseRepository;

@Service
public class ClaseService {
	
	@Autowired
	private ClaseRepository claseRepo;
	
	
	public List<Clase> findAll(){
		return claseRepo.findAll();
	}
	
	public Optional<Clase> findById(Integer id){
		return claseRepo.findById(id);
	}
	
	public Clase save(Clase clase){
		return claseRepo.save(clase);
	}
}
