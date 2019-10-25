package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco;

public class OrigenTranferencia {

	private String cbuOrigen;
	private String amount;

	public OrigenTranferencia() {
		super();
	}

	public OrigenTranferencia(String cbuOrigen, String amount) {
		super();
		this.cbuOrigen = cbuOrigen;
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getCbuOrigen() {
		return cbuOrigen;
	}

	public void setCbuOrigen(String cbuOrigen) {
		this.cbuOrigen = cbuOrigen;
	}

	@Override
	public String toString() {
		return "OrigenTranferencia [cbuOrigen=" + cbuOrigen + ", amount=" + amount + "]";
	}
	
	
}
