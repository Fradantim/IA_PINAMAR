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

import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;

@Component
public class StartUpControllerImpl implements InitializingBean {

	@Autowired
	private MedioDePagoService mdpService;
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpControllerImpl.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		cargarMediosDePago();
	}
	
	private void cargarMediosDePago() {
		logger.debug("> Buscando medios de pago guardados.");
		if(!mdpService.findAll().isEmpty()) {
			logger.debug("< Medios de pago ya estan guardados.");
			return;
		}
		
		logger.debug("No hay medios de pago, los creo y guardo.");
		
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
		logger.debug("< Fin carga Medios de Pago.");
	}
}
