package com.ia.tmi.iatmi.controllerImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.entities.RolPersona;
import com.ia.tmi.iatmi.persistence.service.ClaseService;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;
import com.ia.tmi.iatmi.persistence.service.PaseService;
import com.ia.tmi.iatmi.persistence.service.RolPersonaService;
import com.ia.tmi.iatmi.persistence.service.RolPersonaService.RolPersonaEnum;

@Component
public class StartUpControllerImpl implements InitializingBean {

	@Autowired
	private MedioDePagoService mdpService;
	
	@Autowired
	private ClaseService claseService;
	
	@Autowired
	private PaseService paseService;
	
	@Autowired
	private RolPersonaService rolService;
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpControllerImpl.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Integer i=0;
		cargarMediosDePago(++i);
		cargarClases(++i);
		cargarPases(++i);
		cargarRoles(++i);
		cargarRolesMemoria(++i);
	}
	
	private void cargarMediosDePago(Integer orden) {
		logger.info(orden+"> Buscando medios de pago guardados.");
		if(!mdpService.findAll().isEmpty()) {
			logger.info("< Medios de pago ya estan guardados.");
			return;
		}
		
		logger.info("No hay medios de pago, los creo y guardo.");
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(new ClassPathResource("data/MEDIOS_DE_PAGO.TXT").getFile()));
			String line = reader.readLine();
			while (line != null) {
				MedioDePago mdp = new MedioDePago(line);
				mdpService.save(mdp);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		logger.info("< Fin carga Medios de Pago. "+mdpService.findAll().size()+" elementos cargados.");
	}
	
	private void cargarClases(Integer orden) {
		logger.info(orden+"> Buscando clases guardadas.");
		if(!claseService.findAll().isEmpty()) {
			logger.info("< Clases ya estan guardadas.");
			return;
		}
		
		logger.info("No hay clases, las creo y guardo.");
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(new ClassPathResource("data/CLASES.TXT").getFile()));
			String line = reader.readLine();
			while (line != null) {
				Clase clase = new Clase(line);
				claseService.save(clase);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		logger.info("< Fin carga Clases. "+claseService.findAll().size()+" elementos cargados.");
	}
	
	@SuppressWarnings("deprecation")
	private void cargarPases(Integer orden) {
		logger.info(orden+"> Buscando pases guardados.");
		if(!paseService.findAll().isEmpty()) {
			logger.info("< pases ya estan guardados.");
			return;
		}
		
		logger.info("No hay pases, los creo y guardo.");
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(new ClassPathResource("data/PASES.TXT").getFile()));
			String line = reader.readLine();
			while (line != null) {
				String[] campos = line.split(",");
				Integer cantDias = new Integer(campos [1]);
				String nombre = campos[0];
				Float precio = new Float(campos[2]);
				Pase pase = new Pase(cantDias, nombre, precio);
				paseService.save(pase);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		logger.info("< Fin carga pases. "+paseService.findAll().size()+" elementos cargados.");
	}
	
	private void cargarRoles(Integer orden) {
		logger.info(orden+"> Buscando roles guardados.");
		if(!rolService.findAll().isEmpty()) {
			logger.info("< roles pases ya estan guardados.");
			return;
		}
		
		logger.info("No hay roles, los creo y guardo.");
		
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(new ClassPathResource("data/PASES.TXT").getFile()));
			String line = reader.readLine();
			while (line != null) {
				RolPersona rol = new RolPersona(line);
				rolService.save(rol);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		logger.info("< Fin carga roles. "+rolService.findAll().size()+" elementos cargados.");
	}
	
	private void cargarRolesMemoria(Integer orden) {
		logger.info(orden+"> Cargando Roles a memoria.");
		List<RolPersona> roles = rolService.findAll();
		for(RolPersona rol: roles) {
			RolPersonaEnum.getByKey(rol.getNombre()).setRol(rol);
		}
		logger.info("< Fin carga roles en memoria.");
	}
}
