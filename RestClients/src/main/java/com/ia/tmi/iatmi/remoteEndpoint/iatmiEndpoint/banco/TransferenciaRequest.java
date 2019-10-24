package com.ia.tmi.iatmi.remoteEndpoint.iatmiEndpoint.banco;

public class TransferenciaRequest {

	private String origenCBU;
	private String destinoCBU;
	private String amount;

	public TransferenciaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferenciaRequest(String origenCBU, String destinoCBU, String amount) {
		super();
		this.origenCBU = origenCBU;
		this.destinoCBU = destinoCBU;
		this.amount = amount;
	}

	public String getOrigenCBU() {
		return origenCBU;
	}

	public void setOrigenCBU(String origenCBU) {
		this.origenCBU = origenCBU;
	}

	public String getDestinoCBU() {
		return destinoCBU;
	}

	public void setDestinoCBU(String destinoCBU) {
		this.destinoCBU = destinoCBU;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransferenciaRequest [origenCBU=" + origenCBU + ", destinoCBU=" + destinoCBU + ", amount=" + amount
				+ "]";
	}

	
}
