package com.ia.tmi.iatmi.remoteEndpoint;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;

@Service
public class BancariaRemoteEndpoint {

	/**
	 * Envia la informacion del empleado al endpoint de presentismo para registrar un ingreso
	 */
	public void pagarLiquidacion(String cbuEmpleado, String cuil, String cbuEmpresa, String cuitEmpresa, float montoDepositar) {
		try {
			//TODO Deposita remoto de liquidacion
			;
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar depositar liquidacion al cuil del empleado:   "+ cbuEmpleado +e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
}
