package com.ia.tmi.iatmi.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacion;

@Repository
public interface TipoLiquidacionRespository <T extends TipoLiquidacion> extends JpaRepository<T, Integer> {
	
} 
