package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.repository.SocioRepository;

@Service
public class SocioService {
	
	@Autowired
	private SocioRepository socioRepo;
	
	public List<Socio> findAll(){
		return socioRepo.findAll();
	}
	
	public Socio save(Socio socio) {
		return socioRepo.save(socio);
	}

	public Socio findByID(Integer nroSocio) {
		return socioRepo.getOne(nroSocio);
	}
}
