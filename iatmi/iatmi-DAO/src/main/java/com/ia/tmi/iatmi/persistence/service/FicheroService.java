package com.ia.tmi.iatmi.persistence.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.repository.FicheroRepository;
import com.ia.tmi.iatmi.persistence.repository.PersonaRepository;

@Service
public class FicheroService {
	
	@Autowired
	private FicheroRepository ficheroRepo;
	
	@Autowired
	private PersonaRepository personaRepo;
	
	public List<Fichero> findAll(){
		return ficheroRepo.findAll();
	}
	
	public Optional<Fichero> findById(Integer id){
		return ficheroRepo.findById(id);
	}
	
	public Fichero save(Fichero fichero){
		return ficheroRepo.save(fichero);
	}
	
	public Fichero findFirstByPersonaAndRolOrderByFechaIngresoDesc(Persona persona, RolPersona rol) {
		return ficheroRepo.findFirstByPersonaAndRolOrderByFechaIngresoDesc(persona, rol);
	}
	
	@Deprecated
	public Fichero altaFicheroMock(Integer idPersona, Date ingreso, Date egreso, RolPersona rol) {
		Persona p = personaRepo.findById(idPersona).get();
		Fichero f = new Fichero(p, rol);
		f.setFechaIngreso(ingreso);
		f.setFechaEgreso(egreso);
		return ficheroRepo.save(f);
	}
}
