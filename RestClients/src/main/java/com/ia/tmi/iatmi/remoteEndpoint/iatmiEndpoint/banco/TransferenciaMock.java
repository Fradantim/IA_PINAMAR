package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaMock {

	@Value("${iatmi.CBU}")
	private String cbuEntidad;
	
	@Value("#{'${iatmi.clienteCBU}'.split(',')}")
	private List<String> cbuEmpleados;
	
	@Value("#{'${iatmi.sueldo}'.split(',')}")
	private List<String> sueldosEmpleados;
	

	public String getCbuEntidad() {
		return cbuEntidad;
	}

	public void setCbuEntidad(String cbuEntidad) {
		this.cbuEntidad = cbuEntidad;
	}

	public List<String> getCbuEmpleados() {
		return cbuEmpleados;
	}

	public void setCbuEmpleados(List<String> cbuEmpleados) {
		this.cbuEmpleados = cbuEmpleados;
	}

	public List<String> getSueldosEmpleados() {
		return sueldosEmpleados;
	}

	public void setSueldosEmpleados(List<String> sueldosEmpleados) {
		this.sueldosEmpleados = sueldosEmpleados;
	}
	
	public List<TransferenciaRequest> cargarTransferenciasARealizar(){
		List<TransferenciaRequest> requests = new ArrayList<TransferenciaRequest>();
		for (String cbuEmpleado : getCbuEmpleados()) {
			TransferenciaRequest request = new TransferenciaRequest(this.getCbuEntidad(),cbuEmpleado);
			requests.add(request);
		}
		for (int i = 0; i < requests.size(); i++) {
			requests.get(i).setAmount(getSueldosEmpleados().get(i));
		}
		return requests;
	}
	
}
