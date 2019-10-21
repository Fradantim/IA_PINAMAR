package com.ia.tmi.iatmi.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.repository.Persona;
import com.ia.tmi.iatmi.persistence.repository.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepo;
	
	public List<Persona> findAll(){
		return personaRepo.findAll();
	}
	
	public Persona save(Persona persona) {
		return personaRepo.save(persona);
	}
}
