package com.ia.tmi.iatmi.controllerImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ia.tmi.iatmi.config.CatalogoConfig;
import com.ia.tmi.iatmi.controller.LiquidacionController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.exception.NoPoseeResultadoException;
import com.ia.tmi.iatmi.persistence.entities.Liquidacion;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionDetalle;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionItem;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.service.LiquidacionService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.remoteEndpoint.banco.BancariaRemoteEndpoint;
import com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint.PresentismoFicheroConsumer;
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
	
	@Autowired
	private PresentismoFicheroConsumer presentismoFicheroConsumer;

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
			//liquidacion.cacularLiquidacionPorHora(mes);
			liquidacion.setMontoNeto(calcularLiquidacionPorHora(persona, mes, anio, liquidacion));
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
			throw new NoPoseeResultadoException(
					"No se encontraron liquidacion a procesar en el anio: " + anio + " mes: " + mes);
		}

	}

	@Override
	public List<PersonaDTO> getPersonasAPagar(int anio, int mes) {
		List<PersonaDTO> dtos = new ArrayList<PersonaDTO>();
		List<Persona> personas = liquidacionServices.getPersonByNotPay(anio, mes);
		logger.info("--> Recupero las Personas: " + personas.size());
		if (personas.size() > 0) {
			for (Persona persona : personas) {
				logger.info("--> Consultar empleados por pagar:\nEmpleado: Apellido: "+ persona.getApellido() + " Nombre: " + persona.getNombre()  );
				PersonaDTO dto = new PersonaDTO();
				dto.setApellido(persona.getApellido());
				dto.setNombre(persona.getNombre());
				dto.setCbu(persona.getCBU());
				dto.setId(persona.getId());
				dtos.add(dto);
			}
			return dtos;
		} else {
			throw new NoPoseeResultadoException(
					"No se encontraron Empleados a procesar para pagar en el anio: " + anio + " mes: " + mes);
		}
	}
	
	private Float calcularLiquidacionPorHora(Persona p,  int mes, int anio,Liquidacion liquidacion) {
		Calendar calendarDesde = Calendar.getInstance();
		calendarDesde.set(anio, mes - 1, 1);
		Calendar calendarHasta = Calendar.getInstance();
		calendarHasta.set(anio, mes-1,28);
		int horas = presentismoFicheroConsumer.getHs(p, calendarDesde.getTime(), calendarHasta.getTime());
		logger.info("--> Consultar empleados por horas:\nEmpleado: Nombre: "+ p.getNombre() +  " calcular horas: " + horas);
		float montoBruto = 0F;
		logger.info("--> Consultar empleados por horas:\nEmpleado: Nombre: "+ p.getNombre() +  " liquidaciones detalle: " + ((liquidacion.getLiquidacionDetalles() == null)?null:liquidacion.getLiquidacionDetalles().size()));
		if (liquidacion.getLiquidacionDetalles() != null)
			for (LiquidacionDetalle liquidacionDetalle : liquidacion.getLiquidacionDetalles())
				montoBruto = horas * liquidacionDetalle.getItem().calcularRemunerativo();
		else if (liquidacion.getEmpleado() != null)
			montoBruto = liquidacion.getEmpleado().getSueldoBasicoCostoHora();
		logger.info("--> Consultar empleados por horas:\nEmpleado: Nombre: "+ p.getNombre() +  " monto por horas: " + montoBruto);
		return montoBruto;
	}
}