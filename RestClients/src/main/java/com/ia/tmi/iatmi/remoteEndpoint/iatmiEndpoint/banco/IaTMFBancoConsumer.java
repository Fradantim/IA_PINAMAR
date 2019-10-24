package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.remoteEndpoint.EndpointConsumer;
import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.WSReturn;

@Service
public class IaTMFBancoConsumer extends EndpointConsumer{

	@Value("${entebancario.url}")
	private String transferenciaUrl;
	
	public void transferenciaBancaria(String origenCBU, String destinoCBU, String amount) {

		TransferenciaRequest request = new TransferenciaRequest(origenCBU, destinoCBU, amount);
		WSReturn retorno = getRestTemplate().postForObject(transferenciaUrl+"/trasferir", request, WSReturn.class);
		
		if(!retorno.getSuccessful()) {
			throw new RemoteEndpointException(retorno.getMessage());
		}
	}
}
