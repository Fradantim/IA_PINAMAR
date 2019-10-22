package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.repository.PaseRepository;

@Service
public class PaseService {
	
	@Autowired
	private PaseRepository paseRepo;
	
	
	public List<Pase> findAll(){
		return paseRepo.findAll();
	}
	
	public Optional<Pase> findById(Integer id){
		return paseRepo.findById(id);
	}
	
	public Pase save(Pase pase){
		return paseRepo.save(pase);
	}
}
