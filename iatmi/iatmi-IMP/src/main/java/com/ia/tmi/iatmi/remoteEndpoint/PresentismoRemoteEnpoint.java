package com.ia.tmi.iatmi.remoteEndpoint;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import com.ia.tmi.iatmi.exception.RemoteEndpointException;
import com.ia.tmi.iatmi.persistence.entities.Persona;

@Service
public class PresentismoRemoteEnpoint {

	/**
	 * Envia la informacion del empleado al endpoint de presentismo para registrar un ingreso
	 */
	public void registrarEmpleado(Persona empleado) {
		try {
			//TODO fichado remoto de ingreso
			;
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar registrar un empleado contra el servicio remoto de Presentismo; "+e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
	
	/**
	 * Envia la informacion del empleado al endpoint de presentismo para registrar un ingreso
	 */
	public void registrarIngreso(Persona empleado) {
		try {
			//TODO fichado remoto de ingreso
			;
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar fichar un ingreso contra el servicio remoto de Presentismo; "+e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
	
	/**
	 * Envia la informacion del empleado al endpoint de presentismo para registrar un engreso
	 */
	public void registrarEgreso(Persona empleado) {
		try {
			//TODO fichado remoto de engreso
			;
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar fichar un engreso contra el servicio remoto de Presentismo; "+e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
	
	/**
	 * Pide al Endpoint la suma de hs de un empleado en un anio y mes especificos
	 */
	public void getHoras(Persona empleado, Integer anio, Integer mes) {
		try {
			//TODO solicitud de Hs remota
			;
		} catch (Exception e) {
			throw new RemoteEndpointException("Error al intentar recuperar horas de un empleado contra el servicio remoto de Presentismo; "+e.getMessage()+"; "+e.getLocalizedMessage()+"; "+ExceptionUtils.getStackTrace(e));
		}
	}
}
