package com.ia.tmi.iatmi.remoteEndpoint.banco;

import java.util.List;

public class DespositarSueldosRequest {

	private String cbuDestino;
	private List<OrigenTranferencia> tranferenciasUnicas;
	
	
	public DespositarSueldosRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DespositarSueldosRequest(String cbuDestino, List<OrigenTranferencia> tranferenciasUnicas) {
		super();
		this.cbuDestino = cbuDestino;
		this.tranferenciasUnicas = tranferenciasUnicas;
	}
	public String getCbuDestino() {
		return cbuDestino;
	}
	public void setCbuDestino(String cbuDestino) {
		this.cbuDestino = cbuDestino;
	}
	public List<OrigenTranferencia> getTranferenciasUnicas() {
		return tranferenciasUnicas;
	}
	public void setTranferenciasUnicas(List<OrigenTranferencia> tranferenciasUnicas) {
		this.tranferenciasUnicas = tranferenciasUnicas;
	}
	@Override
	public String toString() {
		return "DespositarSueldosRequest [cbuDestino=" + cbuDestino + ", tranferenciasUnicas=" + toStringList()
				+ "]";
	}
	
	private String toStringList() {
		String msj = "";
		for (OrigenTranferencia origenTranferencia : tranferenciasUnicas) {
			msj = msj + " - "+ origenTranferencia.toString();
		}
		return msj;
	}

}
