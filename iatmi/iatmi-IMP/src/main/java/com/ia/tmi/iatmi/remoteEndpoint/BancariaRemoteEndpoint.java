package com.ia.tmi.iatmi.remoteEndpoint;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.persistence.entities.Pago;

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
	
	/**
	 * Envia la informacion del pago a la entidad
	 */
	public void registrarPago(Pago pago, String nroTarjeta, String fechaVencimiento, String codSeguridad, String DNI) {
		try {
			//TODO fichado remoto de engreso
			//necesito guardarme algun elemento de la respuesta?
			;
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar enviar el pago al servicio remoto de Entidad Bancaria; "+e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
}
