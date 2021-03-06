package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepo;
	
	public List<Persona> findAll(){
		return personaRepo.findAll();
	}
	
	public Persona save(Persona persona) {
		Persona res = personaRepo.save(persona);
		return res; 
	}
	
	public Optional<Persona> findById(Integer id) {
		return personaRepo.findById(id);
	}
	
	public List<Persona> findProfesores(){
		return personaRepo.findProfesores();
	}
	
	public List<Persona> findByRolPersona(RolPersona rol){
		return personaRepo.findyByRolPersona(rol);
	}
}
