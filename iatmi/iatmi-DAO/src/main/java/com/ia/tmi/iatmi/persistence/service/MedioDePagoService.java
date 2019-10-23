package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.repository.MedioDePagoRepository;

@Service
public class MedioDePagoService {
	
	@Autowired
	private MedioDePagoRepository mdpRepo;
	
	
	public List<MedioDePago> findAll(){
		return mdpRepo.findAll();
	}
	
	public Optional<MedioDePago> findById(Integer id){
		return mdpRepo.findById(id);
	}
	
	public MedioDePago save(MedioDePago medioDePago){
		return mdpRepo.save(medioDePago);
	}
	
	public List<MedioDePago> findByEsTarjetaIsNull() {
		return mdpRepo.findByEsTarjetaIsNull();
	}
}
