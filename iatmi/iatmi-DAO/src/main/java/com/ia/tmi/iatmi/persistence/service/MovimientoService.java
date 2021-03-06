package com.ia.tmi.iatmi.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.Movimiento;
import com.ia.tmi.iatmi.persistence.entities.Persona;
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
	
	public List<Movimiento> findByPersona(Persona socio){
		return movimientoRepo.findByPersona(socio);
	}
	
	public Movimiento save(Movimiento movimiento) {
		return movimientoRepo.save(movimiento);
	}
	
	public Optional<Factura> findFacturaById(Integer id) {
		return facturaRepo.findById(id);
	}
	
	public void delete(Factura factura) {
		facturaRepo.delete(factura);
	}
}
