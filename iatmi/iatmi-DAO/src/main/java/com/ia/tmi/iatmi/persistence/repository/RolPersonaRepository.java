package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.RolPersona;

@Repository
public interface RolPersonaRepository extends JpaRepository<RolPersona, String> {
}
