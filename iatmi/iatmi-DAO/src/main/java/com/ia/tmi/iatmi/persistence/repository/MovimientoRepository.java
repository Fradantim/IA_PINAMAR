package com.ia.tmi.iatmi.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Movimiento;
import com.ia.tmi.iatmi.persistence.entities.Habilitacion;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
	
	public List<Movimiento> findBySocio (Habilitacion socio);
}
