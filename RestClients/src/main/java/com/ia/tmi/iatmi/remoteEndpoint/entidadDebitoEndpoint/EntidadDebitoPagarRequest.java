package com.ia.tmi.iatmi.remoteEndpoint.entidadDebitoEndpoint;

import com.ia.tmi.iatmi.persistence.entities.Pago;

public class EntidadDebitoPagarRequest {
	
	private String debitCardNumber;
	private String securityCode;
	private String expirationMonth;
	private String expirationYear;
	private Float amount;
	private String cbu;
	private String detail;
	
	public EntidadDebitoPagarRequest() { }
	
	public EntidadDebitoPagarRequest(Pago pago, String debitCardNumber, String securityCode, String expirationMonth,
			String expirationYear, String cbu) {
		this(debitCardNumber, securityCode, expirationMonth, expirationYear, pago.getMontoTotal(), cbu, "Pago al gimnasio, factura "+pago.getFactura().getId());
	}
	
	public EntidadDebitoPagarRequest(String debitCardNumber, String securityCode, String expirationMonth,
			String expirationYear, Float amount, String cbu, String detail) {
		this.debitCardNumber = debitCardNumber;
		this.securityCode = securityCode;
		this.expirationMonth = expirationMonth;
		this.expirationYear = expirationYear;
		this.amount = amount;
		this.cbu = cbu;
		this.detail = detail;
	}

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getExpirationMonth() {
		return expirationMonth;
	}

	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	public String getExpirationYear() {
		return expirationYear;
	}

	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}
