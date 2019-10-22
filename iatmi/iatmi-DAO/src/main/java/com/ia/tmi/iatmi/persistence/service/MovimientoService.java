package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.Movimiento;
import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.repository.FacturaRepository;
import com.ia.tmi.iatmi.persistence.repository.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepo;
	
	@Autowired
	private FacturaRepository facturaRepo;
	
	public List<Movimiento> findAll(){
		return movimientoRepo.findAll();
	}
	
	public List<Movimiento> findBySocio(Socio socio){
		return movimientoRepo.findBySocio(socio);
	}
	
	public Movimiento save(Movimiento movimiento) {
		return movimientoRepo.save(movimiento);
	}
	
	public Optional<Factura> findFacturaById(Integer id) {
		return facturaRepo.findById(id);
	}
}
