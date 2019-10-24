package com.ia.tmi.iatmi.remoteEndpoint;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.NoPoseeResultadoException;
import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.persistence.entities.Pago;

@Service
public class BancariaRemoteEndpoint {

	private static final Logger logger = LoggerFactory.getLogger(BancariaRemoteEndpoint.class);
	/**
	 *  Depositar liquidacion por empleado del mes y anio solicitado.
	 */
	public void depositarSueldos(String cbuEmpleado, String cuilEmpleado, String cbuEmpresa, String cuitEmpresa, float montoDepositar) {
		try {
			logger.info("-->  Invocar cliente bancario por deposito de sueldo.");
			//TODO Deposita remoto de liquidacion"origenCBU": 13123321123, "destinoCBU": 12, "amount": 2500
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar depositar liquidacion al cuil del empleado:   "+ cuilEmpleado +e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
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
			throw new NoPoseeResultadoException("Error al intentar enviar el pago al servicio remoto de Entidad Bancaria; "+e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
}
