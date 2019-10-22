package com.ia.tmi.iatmi.controllerImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.service.ClaseService;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;

@Component
public class StartUpControllerImpl implements InitializingBean {

	@Autowired
	private MedioDePagoService mdpService;
	
	@Autowired
	private ClaseService claseService;
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpControllerImpl.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		cargarMediosDePago();
		cargarClases();
	}
	
	private void cargarMediosDePago() {
		logger.info("> Buscando medios de pago guardados.");
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
				line = reader.readLine();
				MedioDePago mdp = new MedioDePago(line);
				mdpService.save(mdp);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		logger.info("< Fin carga Medios de Pago. "+mdpService.findAll().size()+" elementos cargados.");
	}
	
	private void cargarClases() {
		logger.info("> Buscando clases guardadas.");
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
				line = reader.readLine();
				Clase clase = new Clase(line);
				claseService.save(clase);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		logger.info("< Fin carga Clases. "+claseService.findAll().size()+" elementos cargados.");
	}
}
