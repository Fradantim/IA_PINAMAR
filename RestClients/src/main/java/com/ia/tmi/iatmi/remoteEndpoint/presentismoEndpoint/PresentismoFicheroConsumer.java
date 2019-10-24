package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.config.LoggingRequestInterceptor;
import com.ia.tmi.iatmi.persistence.entities.Fichero;
import com.ia.tmi.iatmi.persistence.entities.Persona;
import com.ia.tmi.iatmi.remoteEndpoint.EndpointConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint.FicharPresentismoRequest.FicharPresentismoRequestType;

@Service
public class PresentismoFicheroConsumer extends EndpointConsumer {
	
	@Value("${presentimos.fichar.url}")
	private String ficharUrl;
	
	@Value("${presentismos.crearEmpleado.url}")
	private String crearEmpleadoUrl;
	
	@Value("${iatmi.CUIL}")
	private String CUIL;
	
	private static final Logger logger = LoggerFactory.getLogger(PresentismoFicheroConsumer.class);
	
	public void altaEmpleado(Persona persona) {
		CrearEmpleadoPresentismoRequest request = new CrearEmpleadoPresentismoRequest(persona, CUIL);
		logger.debug("Enviando alta de Empleado a sistema de presentismo: "+request);
		
		CrearEmpleadoPresentismoResponse response = getRestTemplate().postForObject(crearEmpleadoUrl, request, CrearEmpleadoPresentismoResponse.class);
		logger.debug("Respuesta recibida: "+ response);
		
		persona.setIdSistemaPresentismo(response.getId().toString());
	}
	
	public void ficharIngreso(Fichero fichero) {
		fichar(fichero, FicharPresentismoRequestType.INGRESO);
	}
	
	public void ficharEgreso(Fichero fichero) {
		fichar(fichero, FicharPresentismoRequestType.EGRESO);
	}
	
	public void fichar(Fichero fichero, FicharPresentismoRequestType type) {
		FicharPresentismoRequest request = new FicharPresentismoRequest(fichero, type);
		logger.debug("Enviando "+ type +" a sistema de presentismo: "+request);
		
		FicharPresentismoResponse response = getRestTemplate().postForObject(crearEmpleadoUrl, ficharUrl, FicharPresentismoResponse.class);
		
		logger.debug("Respuesta recibida: "+ response);
	}
	
	public void getHs(Persona persona) {
		logger.debug("asd");
	}
}