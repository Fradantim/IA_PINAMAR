package com.ia.tmi.iatmi.controllerImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.controller.MovimientoController;
import com.ia.tmi.iatmi.controller.PersonaController;
import com.ia.tmi.iatmi.dto.PersonaDTO;
import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.LiquidacionItem;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.entities.RolPersona.RolPersonaEnum;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionDescuento;
import com.ia.tmi.iatmi.persistence.entities.TipoLiquidacionRemunerativa;
import com.ia.tmi.iatmi.persistence.service.ClaseService;
import com.ia.tmi.iatmi.persistence.service.FicheroService;
import com.ia.tmi.iatmi.persistence.service.LiquidacionService;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;
import com.ia.tmi.iatmi.persistence.service.PaseService;
import com.ia.tmi.iatmi.persistence.service.PersonaService;
import com.ia.tmi.iatmi.persistence.service.RolPersonaService;
import com.ia.tmi.iatmi.persistence.service.TipoEmpleadoService;
import com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint.PresentismoFicheroConsumer;

@Component
public class StartUpControllerImpl implements InitializingBean {

	@Autowired
	private PresentismoFicheroConsumer presentismoConsumer;
	
	@Autowired
	private MedioDePagoService mdpService;

	@Autowired
	private ClaseService claseService;

	@Autowired
	private PaseService paseService;

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private RolPersonaService rolPerService;
	
	@Autowired
	private TipoEmpleadoService tipoEmpService;
	
	@Autowired
	private PersonaController personaController;
	
	@Autowired
	private MovimientoController movController;
	
	@Autowired
	private LiquidacionService liquidacionService;
	
	@Autowired
	private FicheroService ficheroService;
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpControllerImpl.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		Integer i = 0;
		try {
			cachearRoles(++i);
			//cargarMediosDePago(++i);
			//cargarClases(++i);
			//cargarPases(++i);
			//cargaTipoEmpleado(++i);
			//cargaPersonas(++i);
			//cargaTipoLiquidacion();
			//actualizarMediosDePago(++i);
			//cargarFicherosRemoto(++i);
		} catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
	}

	private BufferedReader getReader(String file) throws FileNotFoundException {
		return new BufferedReader(new FileReader("/iatmi/data/" + file));
	}
	
	private void cachearRoles(Integer orden) {
		logger.info(orden+"> Cacheando roles.");
		if(rolPerService.findAll().isEmpty()) {
			logger.info(orden+"tengo que persistirlos.");
			for(RolPersonaEnum rol : RolPersonaEnum.values()) {
				rolPerService.save(new RolPersona(rol.name()));
			}
		}
		
		for(RolPersona rol : rolPerService.findAll()) {
			RolPersonaEnum.valueOf(rol.getId()).setRol(rol);;
		}
		logger.info(orden+"< Fin Cacheando roles.");
	}
	
	private void cargarMediosDePago(Integer orden) throws FileNotFoundException, IOException{
		logger.info(orden+"> Buscando medios de pago guardados.");
		if(!mdpService.findAll().isEmpty()) {
			logger.info("< Medios de pago ya estan guardados.");
			return;
		}

		logger.info("No hay medios de pago, los creo y guardo.");

		BufferedReader reader = getReader("MEDIOS_DE_PAGO.TXT");

		String line = reader.readLine();
		while (line != null) {
			MedioDePago mdp = new MedioDePago(line);
			mdpService.save(mdp);
			line = reader.readLine();
		}
		reader.close();

		logger.info("< Fin carga Medios de Pago. " + mdpService.findAll().size() + " elementos cargados.");
	}

	private void cargarClases(Integer orden) throws FileNotFoundException, IOException {
		logger.info(orden + "> Buscando clases guardadas.");
		if (!claseService.findAll().isEmpty()) {
			logger.info("< Clases ya estan guardadas.");
			return;
		}

		logger.info("No hay clases, las creo y guardo.");

		BufferedReader reader = getReader("CLASES.TXT");

		String line = reader.readLine();
		while (line != null) {
			Clase clase = new Clase(line);
			claseService.save(clase);
			line = reader.readLine();
		}
		reader.close();
		logger.info("< Fin carga Clases. " + claseService.findAll().size() + " elementos cargados.");
	}

	@SuppressWarnings("deprecation")
	private void cargarPases(Integer orden) throws FileNotFoundException, IOException {
		logger.info(orden + "> Buscando pases guardados.");
		if (!paseService.findAll().isEmpty()) {
			logger.info("< pases ya estan guardados.");
			return;
		}

		logger.info("No hay pases, los creo y guardo.");

		BufferedReader reader = getReader("PASES.TXT");

		String line = reader.readLine();
		while (line != null) {
			String[] campos = line.split(",");
			Integer cantDias = new Integer(campos[1]);
			String nombre = campos[0];
			Float precio = new Float(campos[2]);
			Pase pase = new Pase(cantDias, nombre, precio);
			paseService.save(pase);
			line = reader.readLine();
		}
		reader.close();

		logger.info("< Fin carga pases. " + paseService.findAll().size() + " elementos cargados.");
	}

	private void cargaTipoEmpleado(Integer orden) throws IOException {
		logger.info(orden + "> Buscando Tipos de Empleado guardados.");
		if (!tipoEmpService.findAll().isEmpty()) {
			logger.info("< Tipos de Empleado  ya estan guardados.");
			return;
		}

		logger.info("No hay Tipos de Empleado , los creo y guardo.");

		BufferedReader reader = getReader("TIPO_DE_EMPLEADOS.TXT");

		String line = reader.readLine();
		Integer index = 0;
		while (line != null) {
			String[] campos = line.split(",");
			String descripcion = campos[0];
			Boolean esProfesor = Boolean.valueOf(campos[1]);
			Boolean esMensual = Boolean.valueOf(campos[2]);

			TipoEmpleado tipoEmpleado = new TipoEmpleado(descripcion, esProfesor, esMensual);
			tipoEmpleado.setId(++index);

			tipoEmpService.save(tipoEmpleado);
			line = reader.readLine();
		}
		reader.close();

		logger.info("< Fin carga Tipos de Empleado. " + tipoEmpService.findAll().size() + " elementos cargados.");
	}

	
	private void cargaPersonas(Integer orden) {
		logger.info(orden+"> Buscando personas guardadas.");
		if(!personaService.findAll().isEmpty()) {
			logger.info("< personas ya estan guardadas.");
			return;
		}
		
		logger.info("No hay clases, las creo y guardo.");
		
		List<Persona> personas = new ArrayList<Persona>();
		Persona p;

		p = new Persona("Juan", "Ster", "111", "j@s.com", "Masculino", new Date());
		
		p.addRol(RolPersonaEnum.SOCIO.getRol());
		personas.add(p);
		
		p = new Persona("Franco", "Timpone", "222", "f@t.com", "Masculino", new Date());
		p.setSueldoBasicoCostoHora(30000F);
		p.addRol(RolPersonaEnum.EMPLEADO.getRol());
		p.setTipoEmpleado(tipoEmpService.findById(1).get()); //ojo estos hardcodeos
		p.setCUIT("20123456780");
		personas.add(p);
		
		p = new Persona("Alessandro", "Foglio", "333", "a@f.com", "Masculino", new Date());
		p.setSueldoBasicoCostoHora(31000F);
		p.addRol(RolPersonaEnum.EMPLEADO.getRol());
		p.addRol(RolPersonaEnum.SOCIO.getRol());
		p.setTipoEmpleado(tipoEmpService.findById(2).get()); //ojo estos hardcodeos
		p.setCUIT("20234567891");		
		personas.add(p);
		
		p = new Persona("Ezequiel", "Cufre", "444", "e@c.com", "Masculino", new Date());
		p.setSueldoBasicoCostoHora(50F);
		p.addRol(RolPersonaEnum.EMPLEADO.getRol());
		p.setTipoEmpleado(tipoEmpService.findById(3).get()); //ojo estos hardcodeos
		p.setCUIT("20876543219");
		personas.add(p);
		
		p = new Persona("Lisandro", "Rodriguez", "555", "l@r.com", "Masculino", new Date());
		p.setSueldoBasicoCostoHora(50F);
		p.addRol(RolPersonaEnum.SOCIO.getRol());
		p.addRol(RolPersonaEnum.EMPLEADO.getRol());
		p.setTipoEmpleado(tipoEmpService.findById(3).get()); //ojo estos hardcodeos
		p.setCUIT("20222222332");
		personas.add(p);
		
		for(Persona persona: personas) {
			personaService.save(persona);
		}
		
		List<Pase> pases = paseService.findAll();
		List<MedioDePago> mediosDePago = mdpService.findAll();
		
		List<Persona> socios = personaService.findByRolPersona(RolPersonaEnum.SOCIO.getRol());
		for(Persona persona: socios) {
			personaController.asignarPase(persona.getId(), getRandomPaseFromList(pases).getId());
			movController.pagarFactura(
					movController.findBySocio(persona.getId()).get(0).getId(),
					getRandomMDPFromList(mediosDePago).getId()
					);//ojo estos hardcodeos
		}
		
		logger.info("< Fin carga personas. "+personaService.findAll().size()+" elementos cargados.");
		cargarFicheros();
	}
	
	private Pase getRandomPaseFromList(List<Pase> pases) {
	    return pases.get(new Random().nextInt(pases.size()));
	}
	
	private MedioDePago getRandomMDPFromList(List<MedioDePago> mediosDePago) {
	    return mediosDePago.get(new Random().nextInt(mediosDePago.size()));
	}
	
	private void cargaTipoLiquidacion() {
		
		if(!liquidacionService.findItemsAll().isEmpty()) {
			return;
		}

		TipoEmpleado empleado1 =  tipoEmpService.findById(1).get();
		TipoEmpleado empleado2 =  tipoEmpService.findById(2).get();
		TipoEmpleado empleado3 =  tipoEmpService.findById(3).get();
		
		LiquidacionItem item = new LiquidacionItem(1,"Basico", 30F, true);
		item.addTipoLiquidacion(new TipoLiquidacionRemunerativa(1, "Asistencia y Puntualidad", 0.11F, true, 2637.98F,item));
		item.addTipoEmpleado(empleado1);
		liquidacionService.save(item);
		item = new LiquidacionItem(2,"Antiguedad", 0F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(3,"Asistencia y Puntualidad", 2637.98F, true);
		item.addTipoEmpleado(empleado1);
		liquidacionService.save(item);
		item = new LiquidacionItem(4,"Adicional por Zona", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(5,"Horas Extras al 50%", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(6,"Horas Extras al 100%", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(7,"Acuerdo", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(8,"Antiguedad/Acuerdo", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(9,"Asistencia y Puntualidad/Acuerdo", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(10,"Adicional por Zona/Acuerdo", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(11,"Horas Extras al 50%/Acuerdo", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(12,"Jubilacion", 11F, true);
		item.addTipoEmpleado(empleado2);		
		liquidacionService.save(item);
		item = new LiquidacionItem(13,"Ley 19.032n", 3F, true);
		item.addTipoLiquidacion(new TipoLiquidacionDescuento(2, "Jubilacion", 0.11F, true, 0));
		item.addTipoEmpleado(empleado1);		
		liquidacionService.save(item);
		item = new LiquidacionItem(14,"Obra Social", 3F, true);
		item.addTipoLiquidacion(new TipoLiquidacionDescuento(3, "Ley 19.032", 0.031F, true, 0));
		item.addTipoEmpleado(empleado1);
		liquidacionService.save(item);
		item = new LiquidacionItem(15,"S.E.C. Art. 100 CCT 130/75", 2F, true);
		item.addTipoLiquidacion(new TipoLiquidacionDescuento(4, "Obra Social", 0.03F, true, 0));
		item.addTipoEmpleado(empleado1);		
		liquidacionService.save(item);
		item = new LiquidacionItem(16,"F.A.E.C. y S. Art. 100 CCT 130/75", 0.5F, true);
		item.addTipoLiquidacion(new TipoLiquidacionDescuento(5, "S.E.C. Art. 100 CCT 130/75", 0.02F, true, 0));
		item.addTipoEmpleado(empleado1);		
		liquidacionService.save(item);
		item = new LiquidacionItem(17,"S.E.C. Art. 101 CCT 130/75", 2F, true);
		item.addTipoLiquidacion(new TipoLiquidacionDescuento(6, "F.A.E.C. y S. Art. 100 CCT 130/75", 0.005F, true, 0));
		item.addTipoEmpleado(empleado1);		
		liquidacionService.save(item);
		item = new LiquidacionItem(18,"Liquidacion por horas trabajadas", 0F, true);
		item.addTipoLiquidacion(new TipoLiquidacionDescuento(7, "S.E.C. Art. 101 CCT 130/75", 0.002F, true, 0));
		item.addTipoEmpleado(empleado3);		
		liquidacionService.save(item);
		
//		List<TipoLiquidacion> liquidacion = new ArrayList<TipoLiquidacion>();
//		liquidacion.add(new TipoLiquidacionRemunerativa(1, "Asistencia y Puntualidad", 0.11F, true, 2637.98F,item));
//		item.addTipoLiquidacion(liquidacion.get(0));
//		liquidacion.add(new TipoLiquidacionDescuento(2, "Jubilacion", 0.11F, true, 0));
//		liquidacion.add(new TipoLiquidacionDescuento(3, "Ley 19.032", 0.031F, true, 0));
//		liquidacion.add(new TipoLiquidacionDescuento(4, "Obra Social", 0.03F, true, 0));
//		liquidacion.add(new TipoLiquidacionDescuento(5, "S.E.C. Art. 100 CCT 130/75", 0.02F, true, 0));
//		liquidacion.add(new TipoLiquidacionDescuento(6, "F.A.E.C. y S. Art. 100 CCT 130/75", 0.005F, true, 0));
//		liquidacion.add(new TipoLiquidacionDescuento(7, "S.E.C. Art. 101 CCT 130/75", 0.002F, true, 0));
//		for (TipoLiquidacion tipoLiquidacion : liquidacion) {
//			if (tipoLiquidacion instanceof TipoLiquidacionNoRemunerativa) {
//				TipoLiquidacionNoRemunerativa tlnr = (TipoLiquidacionNoRemunerativa) tipoLiquidacion;
//				liquidacionService.save(liquidacion.get(0));
//				logger.info("< Tipo creado. "+tlnr.getId()+" No Remunerativa.");
//			}
//			if (tipoLiquidacion instanceof TipoLiquidacionRemunerativa) {
//				TipoLiquidacionRemunerativa tlr = (TipoLiquidacionRemunerativa) tipoLiquidacion;
//				liquidacionService.save(tlr);
//				logger.info("< Tipo creado. "+tlr.getId()+"  Remunerativa.");
//			}
//			if (tipoLiquidacion instanceof TipoLiquidacionDescuento) {
//				TipoLiquidacionDescuento tld = (TipoLiquidacionDescuento) tipoLiquidacion;
//				liquidacionService.save(tld);
//				logger.info("< Tipo creado. "+tld.getId()+" Descuento.");
//			}
//
//			
//		}

	}
	
	private void cargarFicheros() {
		logger.info(" > Cargando Ficheros.");
		LocalDate start = LocalDate.of(2019, 9, 1);
		LocalDate end = start.plusDays(50);
		
		for(PersonaDTO persona: personaController.findEmpleados()) {
			for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
				Date ingreso = Date.from( date.atTime(9, 0).atZone( ZoneId.systemDefault()).toInstant());
				Date egreso = Date.from( date.atTime(18, 0).atZone( ZoneId.systemDefault()).toInstant());
				ficheroService.altaFicheroMock(persona.getId(), ingreso, egreso, RolPersonaEnum.EMPLEADO.getRol());
			}
		}
		
		logger.info("< Fin carga Ficheros. " + ficheroService.findAll().size() + " elementos cargados.");
	}
	
	private void actualizarMediosDePago(Integer orden) {
		logger.info(orden+"> Buscando medios de pago actualizados.");
		
		List <MedioDePago> mediosDePago = mdpService.findByEsTarjetaIsNull(); 
		if(mediosDePago.isEmpty()) {
			logger.info("< Medios de pago ya estan actualizdos.");
			return;
		}
		
		for(MedioDePago mdp: mediosDePago) {
			mdp.setEsTarjeta(mdp.getNombre().trim().toUpperCase().startsWith("TARJETA"));
		}
		
		for(MedioDePago mdp: mediosDePago) {
			mdpService.save(mdp);
		}
		

		logger.info("No estan actualizados, los actualizo.");
		
		logger.info("< Fin actualizacion Medios de Pago. ");
	}
	
	@Deprecated
	private void cargarFicherosRemoto(Integer orden) {
		//ATENTI!!! CORRERLO UNA SOLA VEZ!!!
		//USARLO SOLO SI PRESENTISMO LIMPIA LA BBDD
		logger.info(orden+" > Cargando Ficheros al sistma de Presentismo.");
		LocalDate start = LocalDate.of(2019, 9, 1);
		LocalDate end = start.plusDays(50);
		
		for(Persona persona: personaService.findAll()) {
			if(persona.hasRol(RolPersonaEnum.EMPLEADO.getRol())) {
				logger.info("-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-++-+-+");
				logger.info("Alta empleado:"+persona.getId());
				presentismoConsumer.altaEmpleado(persona);
				logger.info("-+-+-+-+--+-+-+-+-+-+-+-+-+-+-+-+-++-+-+");		
				for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
					if(!date.getDayOfWeek().equals(DayOfWeek.SATURDAY) 
							&& !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
						Date ingreso = Date.from( date.atTime(9, 0).atZone( ZoneId.systemDefault()).toInstant());
						Date egreso = Date.from( date.atTime(18, 0).atZone( ZoneId.systemDefault()).toInstant());
						Fichero fichero = new Fichero(persona, RolPersonaEnum.EMPLEADO.getRol());
						fichero.setFechaIngreso(ingreso);
						fichero.setFechaEgreso(egreso);
						presentismoConsumer.ficharIngreso(fichero);
						presentismoConsumer.ficharEgreso(fichero);
					}
				}
			}
		}		
		logger.info("< Fin carga Ficheros en sistema de Presentismo. " + ficheroService.findAll().size() + " elementos cargados.");
	}
}
