package com.ia.tmi.iatmi.remoteEndpoint.entidadDebitoEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.persistence.entities.Pago;
import com.ia.tmi.iatmi.remoteEndpoint.EndpointConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.entidadCreditoEndpoint.Cuota;

@Service
public class EntidadDebitoConsumer extends EndpointConsumer{

	@Value("${iatmi.CBU}")
	private String CBU;
	
	@Value("${entebancario.pagar.url}")
	private String pagarUrl;

	private static final Logger logger = LoggerFactory.getLogger(EndpointConsumer.class);
	
	public void pagarFactura(Pago pago, String debitCardNumber, String expirationMonth, String expirationYear, String securityCode) {
		EntidadDebitoPagarRequest request = new EntidadDebitoPagarRequest(pago, debitCardNumber, securityCode, expirationMonth, expirationYear, CBU);
		logger.debug("Enviando pago con TD a sistema Ente Debito Banco: "+request);
		
		Cuota[] response = getRestTemplate().postForObject(pagarUrl, request, Cuota[].class);
		logger.debug("Respuesta recibida: "+ response);
	}
	
}