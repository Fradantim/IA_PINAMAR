package com.ia.tmi.iatmi.remoteEndpoint.banco;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.WSReturn;

@Service
public class IaTMFBancarioConsumer {

	@Value("${iatmi.fichero.transferencia.url}")
	private String transferenciaUrl;
	
	public void transferenciaBancaria(String origenCBU, String destinoCBU, String amount) {

		TranferenciaRequest request = new TranferenciaRequest(origenCBU, destinoCBU, amount);
		WSReturn retorno = new RestTemplate().postForObject(transferenciaUrl, request, WSReturn.class);
		
		if(!retorno.getSuccessful()) {
			throw new RemoteEndpointException(retorno.getMessage());
		}
	}
}
