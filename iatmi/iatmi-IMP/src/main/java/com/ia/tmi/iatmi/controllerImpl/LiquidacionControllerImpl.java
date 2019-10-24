package com.ia.tmi.iatmi.controllerImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.config.CatalogoConfig;
import com.ia.tmi.iatmi.controller.LiquidacionController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Liquidacion;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionItem;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.service.LiquidacionService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.remoteEndpoint.BancariaRemoteEndpoint;
import com.ia.tmi.iatmi.transformers.PersonaTransformer;

@Controller
public class LiquidacionControllerImpl implements LiquidacionController {

	@Autowired
	public LiquidacionService liquidacionServices;

	@Autowired
	public PersonaService personaService;

	@Autowired
	private PersonaTransformer personaTransformer;

	@Autowired
	private CatalogoConfig catalogo;

	@Autowired
	private BancariaRemoteEndpoint entidadBancaria;

	@Override
	public List<PersonaDTO> findPersonaLiquidacionAnioMesAll(int anio, int mes) {
		return personaTransformer.transform(liquidacionServices.findPersonaByLiquidacionAnioMesAll(anio, mes));
	}

	private static final Logger logger = LoggerFactory.getLogger(LiquidacionControllerImpl.class);

	@Override
	public void guardarLiquidacion(int idEmpleado, int anio, int mes) {
		Optional<Persona> p = personaService.findById(idEmpleado);
		Persona persona = p.get();

		logger.info("--> Persona: " + persona.getId().toString());

		Liquidacion liquidacion = new Liquidacion(persona);
		Calendar calendar = Calendar.getInstance();
		calendar.set(anio, mes - 1, 20);
		liquidacion.setFecha(calendar.getTime());
		for (LiquidacionItem items : persona.getTipoEmpleado().getLiquidacionItems()) {
			logger.info(
					"--> Items Id: " + items.getId() + " Tipo Persona:  " + persona.getTipoEmpleado().getDescripcion()
							+ " Items: " + items.getValor() + " Tipos: " + items.getTiposLiquidaciones().size());
			liquidacion.addLiquidacionItem(items);
		}
		if (persona.getTipoEmpleado().getEsMensual())
			liquidacion.cacularLiquidacionMes();
		else
			liquidacion.cacularLiquidacionPorHora(mes);
		liquidacionServices.save(liquidacion);
	}

	@Override
	public void depositarLiquidaciones(int anio, int mes) {
		List<Liquidacion> liquidaciones = liquidacionServices.depositPersonByLiquidacion(anio, mes);
		logger.info("--> Recupero las liquidaciones: " + liquidaciones.size());
		if (liquidaciones.size() > 0) {
			for (Liquidacion liquidacion : liquidaciones) {
				logger.info("--> Depositar los siguientes sueldo por liquidacion:\nCBU empleado: "
						+ liquidacion.getEmpleado().getCBU() + " Cuil Empleado: " + liquidacion.getEmpleado().getCUIT()
						+ " CBU Gym: " + catalogo.getCBU() + " Cuil Entidad Gym: " + catalogo.getCUIL()
						+ " Deposito el Sueldo Neto: " + liquidacion.getMontoNeto());
				entidadBancaria.depositarSueldos(liquidacion.getEmpleado().getCBU(),
						liquidacion.getEmpleado().getCUIT(), catalogo.getCBU(), catalogo.getCUIL(),
						liquidacion.getMontoNeto());
				logger.info("--> Deposito realizado");
				Liquidacion liquidacionPaga = liquidacionServices.findById(liquidacion.getId());
				logger.info("--> Liquidacion Pagada: " + liquidacion.getId() + " a entidad bancaria.");
				liquidacionPaga.setFechaPago(new Date());
				liquidacionServices.save(liquidacionPaga);
				logger.info("--> Liquidacion cerrada: " + liquidacion.getId() + " fecha de pago: "
						+ liquidacion.getFechaPago());
			}
		} else {
			throw new NoSuchElementException(
					"No se encontraron liquidacion a procesar por el anio: " + anio + " mes: " + mes);
		}

	}
}