package com.ia.tmi.iatmi.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.MedioDePago;

@Repository
public interface MedioDePagoRepository extends JpaRepository<MedioDePago, Integer> {
	
	public List<MedioDePago> findByEsTarjetaIsNull();
}
