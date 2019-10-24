package com.ia.tmi.iatmi.remoteEndpoint.presentismoEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ia.tmi.iatmi.persistence.entities.Persona;

@Service
public class PresentismoFicheroConsumer {
	
	@Value("${presentismo.url}")
	private String ingresoUrl;
	
	@Value("${presentismos.crearEmpleado.url}")
	private String crearEmpleadoUrl;
	
	@Value("${iatmi.CUIL}")
	private String CUIL;
	
	private static final Logger logger = LoggerFactory.getLogger(PresentismoFicheroConsumer.class);
	
	public void altaEmpleado(Persona persona) {
		CrearEmpleadoPresentismoRequest request = new CrearEmpleadoPresentismoRequest(persona, CUIL);
		logger.debug("Enviando alta de Empleado a sistema de presentismo: "+request);
		
		CrearEmpleadoPresentismoResponse response = new RestTemplate().postForObject(crearEmpleadoUrl, request, CrearEmpleadoPresentismoResponse.class);
		logger.debug("Respuesta recibida: "+ response);
		
		persona.setIdSistemaPresentismo(response.getId().toString());
	}
	
	public void ficharIngreso(Persona persona, String idRol) {
		
	}
	
	public void ficharEgreso(Persona persona, String idRol) {
		
	}
	
	public void getHs(Persona persona) {
		
	}
}