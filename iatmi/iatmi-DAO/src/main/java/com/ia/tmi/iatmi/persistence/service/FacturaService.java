package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.repository.FacturaRepository;

@Service
public class FacturaService {
	
	@Autowired
	private FacturaRepository factRepo;
	
	
	public List<Factura> findAll(){
		return factRepo.findAll();
	}
	
	public Optional<Factura> findById(Integer id){
		return factRepo.findById(id);
	}
	
	public Factura save(Factura factura){
		return factRepo.save(factura);
	}
}
