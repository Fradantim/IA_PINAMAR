package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;

@Repository
public interface FicheroRepository extends JpaRepository<Fichero, Integer> {
	
	public Fichero findFirstByPersonaAndRolOrderByFechaIngresoDesc(Persona persona, RolPersona rol);
}
