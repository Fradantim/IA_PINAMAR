package com.ia.tmi.iatmi.controllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.controller.MovimientoController;
import com.ia.tmi.iatmi.dto.MovimientoDTO;
import com.ia.tmi.iatmi.persistence.entities.Factura;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.entities.Pago;
import com.ia.tmi.iatmi.persistence.entities.Socio;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;
import com.ia.tmi.iatmi.persistence.service.MovimientoService;
import com.ia.tmi.iatmi.persistence.service.SocioService;
import com.ia.tmi.iatmi.transformers.MovimientoTransformer;

@Controller
public class MovimientoControllerImpl implements MovimientoController{

	@Autowired
	private MovimientoService movService;
	
	@Autowired
	private MedioDePagoService mdpService;
	
	@Autowired
	private SocioService socService;
	
	@Autowired
	private MovimientoTransformer movTransformer;
	
	@Override
	public List<MovimientoDTO> findAll() {
		return movTransformer.transform(movService.findAll());
	}

	@Override
	public List<MovimientoDTO> findBySocio(Integer idSocio) {
		Socio socio = socService.findById(idSocio).get();
		return movTransformer.transform(movService.findBySocio(socio));
	}

	@Override
	public void pagarFactura(Integer idFactura, Integer idMedioDePago) {
		Factura factura = movService.findFacturaById(idFactura).get();
		MedioDePago mdp = mdpService.findById(idMedioDePago).get();
		Pago pago = new Pago(factura, mdp);
		movService.save(pago);
	}	
}
