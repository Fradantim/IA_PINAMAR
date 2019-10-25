package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.remoteEndpoint.EndpointConsumer;

@Service
public class IaTMFBancoConsumer extends EndpointConsumer{

	@Value("${entebancario.url}")
	private String transferenciaUrl;
	
	public void transferenciaBancaria(String origenCBU, String destinoCBU, String amount) {

		TransferenciaRequest request = new TransferenciaRequest(origenCBU, destinoCBU, amount);
		WSRemoteReturn retorno = getRestTemplate().postForObject(transferenciaUrl+"/trasferir", request, WSRemoteReturn.class);
		
		if(!retorno.getSuccess()) {
			throw new RemoteEndpointException(retorno.getMessage());
		}
	}
	
	
	/**
	 *  Depositar liquidacion por empleado del mes y anio solicitado de una nomina
	 */
	public void depositarTodosLosSueldos(String cbuDestino, List<OrigenTranferencia> origenes) {
		try {
			System.out.println("-->  Invocar clientes bancario por deposito de sueldo. CBU Destino: " + cbuDestino);
			DespositarSueldosRequest request = new DespositarSueldosRequest(cbuDestino, origenes);
			WSDespositarResponse retorno = getRestTemplate().postForObject(transferenciaUrl+"/pagar/varios", request, WSDespositarResponse.class);		
			System.out.println("-->  Respuesta clientes bancario por deposito de sueldo. CBU Destino: " + retorno.toString());
			if(!retorno.getSuccess()) {
				throw new RemoteEndpointException(retorno.toStringListMsj());
			}
		} catch (Exception e) {
			throw new RemoteEndpointException(e.getMessage());
		}
	}
}
