package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;

@Service
public class IaTMIFicheroConsumer {
	
	@Value("${iatmi.fichero.ingreso.url}")
	private String ingresoUrl;
	
	@Value("${iatmi.fichero.egreso.url}")
	private String egresoUrl;
	
	public void ficharIngreso(Integer idPersona, String idRol) {

		FichadoRequest request = new FichadoRequest(idPersona, idRol); 
		WSReturn<?> retorno = new RestTemplate().postForObject(ingresoUrl, request, WSReturn.class);
		
		if(!retorno.getSuccessful()) {
			throw new RemoteEndpointException(retorno.getMessage());
		}
	}
	
	public void ficharEgreso(Integer idPersona, String idRol) {

		FichadoRequest request = new FichadoRequest(idPersona, idRol); 
		WSReturn<?> retorno = new RestTemplate().postForObject(egresoUrl, request, WSReturn.class);
		
		if(!retorno.getSuccessful()) {
			throw new RemoteEndpointException(retorno.getMessage());
		}
	}
}