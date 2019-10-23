package com.ia.tmi.iatmi.persistence.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Liquidacion;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionItem;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacion;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionDescuento;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionNoRemunerativa;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionRemunerativa;
import com.ia.tmi.iatmi.persistence.repository.LiquidacionItemRepository;
import com.ia.tmi.iatmi.persistence.repository.LiquidacionRepository;
import com.ia.tmi.iatmi.persistence.repository.TipoLiquidacionRespository;

@Service
public class LiquidacionService {

	@Autowired
	private TipoLiquidacionRespository<TipoLiquidacion> tipoLiquidacionRepo;

	@Autowired
	private LiquidacionRepository liquidacionRepo;

	@Autowired
	private TipoLiquidacionRespository<TipoLiquidacionRemunerativa> tipoRemunerativaRepo;

	@Autowired
	private TipoLiquidacionRespository<TipoLiquidacionNoRemunerativa> tipoNoRemunerativaRepo;

	@Autowired
	private TipoLiquidacionRespository<TipoLiquidacionDescuento> tipoDescuentoRepo;

	@Autowired
	private LiquidacionItemRepository liquidacionItemRepo;

	private static final Logger logger = LoggerFactory.getLogger(LiquidacionService.class);

	public List<TipoLiquidacionRemunerativa> findTypeRemunerativaAll() {
		return tipoRemunerativaRepo.findAll();
	}

	public List<TipoLiquidacionNoRemunerativa> findTypeNoRemunerativaAll() {
		return tipoNoRemunerativaRepo.findAll();
	}

	public List<TipoLiquidacionDescuento> findTypeDescuetnoAll() {
		return tipoDescuentoRepo.findAll();
	}

	public Liquidacion findById(Integer id) {
		return liquidacionRepo.findById(id).get();
	}
	
	public TipoLiquidacion save(TipoLiquidacion tipo) {
		return tipoLiquidacionRepo.save(tipo);
	}

	public Liquidacion save(Liquidacion liquidacion) {
		return liquidacionRepo.save(liquidacion);
	}

	public List<LiquidacionItem> findItemsAll() {
		return liquidacionItemRepo.findAll();
	}

	public LiquidacionItem save(LiquidacionItem item) {
		return liquidacionItemRepo.save(item);
	}

	public List<Persona> findPersonaByLiquidacionAnioMesAll(int anio, int mes) {
		List<Persona> personas = new ArrayList<Persona>();
		List<Object[]> rows = liquidacionRepo.findAllLiquidacionPersona(anio, mes);
		for (Object[] objects : rows) {		
			personas.add(Persona.toPersona(((objects[0] == null) ? null : (Integer) objects[0]),(String) objects[1],(String) objects[2],(String) objects[3],(Date)objects[4],(Date) objects[5],(String) objects[6],(String) objects[7], ((objects[8] == null) ? null : ((Double)objects[8]).floatValue()),((objects[9] == null) ? null : (Integer) objects[9]),((objects[10] == null) ? null : (Integer) objects[10])));
		}
		return personas;
	}
	public List<Liquidacion> payPersonaByLiquidacion(int anio, int mes){
		List<Liquidacion> liquidacionPagar= new ArrayList<Liquidacion>();
		List<Object[]> rows = liquidacionRepo.findNotPayLiquidacionPersona(anio, mes);
		for (Object[] objects : rows) {	
			logger.info(objects.toString());
			Persona persona = new Persona();
			persona.setId(((objects[0] == null) ? null : (Integer) objects[0]));
			persona.setApellido((String) objects[1]);
			persona.setCBU((String) objects[2]);
			persona.setNombre((String) objects[3]);
			Liquidacion liquidacion = new Liquidacion();
			liquidacion.setId(((objects[4] == null) ? null : (Integer) objects[4]));
			liquidacion.setMontoNeto((objects[5] == null) ? null : ((Float)objects[5]));
			liquidacion.setEmpleado(persona);
			liquidacionPagar.add(liquidacion);
		}
		return liquidacionPagar;
	}
}
