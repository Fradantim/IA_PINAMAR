package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Habilitacion;
import com.ia.tmi.iatmi.persistence.repository.HabilitacionRepository;

@Service
public class HabilitacionService {
	
	@Autowired
	private HabilitacionRepository habRepo;
	
	
	public List<Habilitacion> findAll(){
		return habRepo.findAll();
	}
	
	public Optional<Habilitacion> findById(Integer id){
		return habRepo.findById(id);
	}
	
	public Habilitacion save(Habilitacion habilitacion){
		return habRepo.save(habilitacion);
	}
}
