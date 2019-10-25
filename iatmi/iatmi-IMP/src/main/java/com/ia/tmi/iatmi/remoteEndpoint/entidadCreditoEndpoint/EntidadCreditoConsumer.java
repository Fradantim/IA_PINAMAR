package com.ia.tmi.iatmi.remoteEndpoint.entidadCreditoEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.persistence.entities.Pago;
import com.ia.tmi.iatmi.remoteEndpoint.EndpointConsumer;

@Service
public class EntidadCreditoConsumer extends EndpointConsumer{
	
	@Value("${iatmi.CUIL}")
	private String CUIL;
	
	@Value("${entecredito.pagar.url}")
	private String pagarUrl;
	
	
	private static final Logger logger = LoggerFactory.getLogger(EndpointConsumer.class);
	
	public void pagarFactura(Pago pago, String cardNumber, String dniCuilCuit, String expirationDate, String securityCode) {
		try {
			EnteCreditoPagarRequest request = new EnteCreditoPagarRequest(pago, cardNumber, dniCuilCuit, CUIL, expirationDate, securityCode);
			logger.debug("Enviando pago con TC a sistema Ente Credito: "+request);
			
			Cuota[] response = getRestTemplate().postForObject(pagarUrl, request, Cuota[].class);
			logger.debug("Respuesta recibida: "+ response);
		} catch (Exception e) {
			throw new RemoteEndpointException("Error de comunicacion al consumir el servicio del Ente Crediticio. "+e.getMessage());
		}
	}
}
