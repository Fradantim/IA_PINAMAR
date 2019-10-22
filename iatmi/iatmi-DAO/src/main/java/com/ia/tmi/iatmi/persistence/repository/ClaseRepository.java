package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer> {
}
