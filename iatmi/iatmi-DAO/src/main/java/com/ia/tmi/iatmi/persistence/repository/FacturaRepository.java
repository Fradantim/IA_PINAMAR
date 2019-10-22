package com.ia.tmi.iatmi.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.Movimiento;
import com.ia.tmi.iatmi.persistence.entities.Socio;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
	
	public List<Movimiento> findBySocio (Socio socio);
}
