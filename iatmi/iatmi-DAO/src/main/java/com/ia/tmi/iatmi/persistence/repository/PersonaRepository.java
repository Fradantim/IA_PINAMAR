package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ia.tmi.iatmi.persistence.entities.Persona;

@NoRepositoryBean
public interface PersonaRepository<T extends Persona> extends JpaRepository<T, Integer> {

}
