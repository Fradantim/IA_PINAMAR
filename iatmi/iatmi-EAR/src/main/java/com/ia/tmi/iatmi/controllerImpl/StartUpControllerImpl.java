package com.ia.tmi.iatmi.controllerImpl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ia.tmi.iatmi.persistence.entities.Clase;
import com.ia.tmi.iatmi.persistence.entities.MedioDePago;
import com.ia.tmi.iatmi.persistence.entities.Pase;
import com.ia.tmi.iatmi.persistence.entities.TipoEmpleado;
import com.ia.tmi.iatmi.persistence.service.ClaseService;
import com.ia.tmi.iatmi.persistence.service.MedioDePagoService;
import com.ia.tmi.iatmi.persistence.service.PaseService;
import com.ia.tmi.iatmi.persistence.service.TipoEmpleadoService;

@Component
public class StartUpControllerImpl implements InitializingBean {

	@Autowired
	private MedioDePagoService mdpService;
	
	@Autowired
	private ClaseService claseService;
	
	@Autowired
	private PaseService paseService;
	
	@Autowired
	private TipoEmpleadoService tipoEmpService;
	
	private static final Logger logger = LoggerFactory.getLogger(StartUpControllerImpl.class);
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//testInsert();
		Integer i=0;
		try {
			cargarMediosDePago(++i);
			cargarClases(++i);
			cargarPases(++i);
			cargaTipoEmpleado(++i);
		} catch (Exception e) {
			logger.error("No se encontró un archivo!!!!"+e.getMessage());
		}
	}
	
	private BufferedReader getReader(String file) throws FileNotFoundException {
		return new BufferedReader(new FileReader("/iatmi/data/"+file));
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
			
		logger.info("< Fin carga Medios de Pago. "+mdpService.findAll().size()+" elementos cargados.");
	}
	
	private void cargarClases(Integer orden) throws FileNotFoundException, IOException{
		logger.info(orden+"> Buscando clases guardadas.");
		if(!claseService.findAll().isEmpty()) {
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
		logger.info("< Fin carga Clases. "+claseService.findAll().size()+" elementos cargados.");
	}
	
	@SuppressWarnings("deprecation")
	private void cargarPases(Integer orden) throws FileNotFoundException, IOException{
		logger.info(orden+"> Buscando pases guardados.");
		if(!paseService.findAll().isEmpty()) {
			logger.info("< pases ya estan guardados.");
			return;
		}
		
		logger.info("No hay pases, los creo y guardo.");
		
		BufferedReader reader = getReader("PASES.TXT");
		
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
			
		logger.info("< Fin carga pases. "+paseService.findAll().size()+" elementos cargados.");
	}
	
	private void cargaTipoEmpleado(Integer orden) throws IOException {
		logger.info(orden+"> Buscando Tipos de Empleado guardados.");
		if(!tipoEmpService.findAll().isEmpty()) {
			logger.info("< Tipos de Empleado  ya estan guardados.");
			return;
		}
		
		logger.info("No hay Tipos de Empleado , los creo y guardo.");
				
		BufferedReader reader = getReader("TIPO_DE_EMPLEADOS.TXT");
		
		String line = reader.readLine();
		Integer index =0;
		while (line != null) {
			String[] campos= line.split(",");
			String descripcion = campos[0];
			Boolean esProfesor = Boolean.valueOf(campos[1]);
			Boolean esMensual = Boolean.valueOf(campos[2]);
			
			TipoEmpleado tipoEmpleado = new TipoEmpleado(descripcion, esProfesor, esMensual);
			tipoEmpleado.setId(++index);
			
			tipoEmpService.save(tipoEmpleado);
			line = reader.readLine();
		}
		reader.close();
			
		logger.info("< Fin carga Tipos de Empleado. "+tipoEmpService.findAll().size()+" elementos cargados.");
	}
}
