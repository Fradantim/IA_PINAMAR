package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.FichaMedica;
import com.ia.tmi.iatmi.persistence.repository.FichaMedicaRepository;

@Service
public class FichaMedicaService {
	
	@Autowired
	private FichaMedicaRepository fichaRepo;
	
	
	public List<FichaMedica> findAll(){
		return fichaRepo.findAll();
	}
	
	public Optional<FichaMedica> findById(Integer id){
		return fichaRepo.findById(id);
	}
	
	public FichaMedica save(FichaMedica clase){
		return fichaRepo.save(clase);
	}
}
