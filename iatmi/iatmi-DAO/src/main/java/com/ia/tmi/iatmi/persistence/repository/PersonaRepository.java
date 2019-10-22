package com.ia.tmi.iatmi.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.Persona.RolPersona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
 
	@Query("SELECT p from Persona p WHERE p.tipoEmpleado.esProfesor is true")
	public List<Persona> findProfesores();
	 
	@Query("SELECT p from Persona p WHERE rol in p.roles") 
	public List<Persona> findyByRolPersona(@Param("rol") RolPersona rol);
}
