package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.MovimientoController;
import com.ia.tmi.iatmi.dto.MovimientoDTO;
import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.entities.Pago;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;
import com.ia.tmi.iatmi.persistence.service.MovimientoService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.remoteEndpoint.entidadCreditoEndpoint.EntidadCreditoConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.entidadDebitoEndpoint.EntidadDebitoConsumer;
import com.ia.tmi.iatmi.transformers.MovimientoTransformer;

@Controller
public class MovimientoControllerImpl implements MovimientoController{
	
	@Autowired
	private EntidadDebitoConsumer entidadDeb;
	
	@Autowired
	private EntidadCreditoConsumer entidadCred;
	
	@Autowired
	private MovimientoService movService;
	
	@Autowired
	private MedioDePagoService mdpService;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private MovimientoTransformer movTransformer;
	
	@Override
	public List<MovimientoDTO> findAll() {
		return movTransformer.transform(movService.findAll());
	}

	@Override
	public List<MovimientoDTO> findBySocio(Integer idSocio) {
		Persona persona = personaService.findById(idSocio).get();
		return movTransformer.transform(movService.findByPersona(persona));
	}

	@Override
	public void pagarFactura(Integer idFactura, Integer idMedioDePago) {
		pagarFactura(idFactura, idMedioDePago, null, null, null, null);
	}

	@Override
	public void pagarFactura(Integer idFactura, Integer idMedioDePago, String nroTarjeta, String fechaVencimiento,
			String codSeguridad, String DNI) {
		Factura factura = movService.findFacturaById(idFactura).get();
		MedioDePago mdp = mdpService.findById(idMedioDePago).get();
		Pago pago = new Pago(factura, mdp);
		
		if(mdp.esTC()) {
			entidadCred.pagarFactura(pago, nroTarjeta, DNI, fechaVencimiento, codSeguridad);
		}
		
		if(mdp.esTD()) {
			String mes = fechaVencimiento.substring(0,2);
			String year = fechaVencimiento.substring(3,4);
			entidadDeb.pagarFactura(pago, nroTarjeta, mes, year, codSeguridad);
		}
		movService.save(pago);
		
	}	
}
