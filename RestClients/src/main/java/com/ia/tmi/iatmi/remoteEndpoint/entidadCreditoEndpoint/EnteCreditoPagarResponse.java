package com.ia.tmi.iatmi.remoteEndpoint.entidadCreditoEndpoint;

import java.util.Arrays;

public class EnteCreditoPagarResponse {
	
	private Cuota[] cuotas;
		
	public EnteCreditoPagarResponse() { }
	
	public EnteCreditoPagarResponse(Cuota[] cuotas) {
		super();
		this.cuotas = cuotas;
	}
	
	@Override
	public String toString() {
		return "EnteCreditoPagarResponse [cuotas=" + Arrays.toString(cuotas) + "]";
	}

	public Cuota[] getCuotas() {
		return cuotas;
	}

	public void setCuotas(Cuota[] cuotas) {
		this.cuotas = cuotas;
	}
}
