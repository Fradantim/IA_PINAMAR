package com.ia.tmi.iatmi.remoteEndpoint.entidadCreditoEndpoint;

import com.ia.tmi.iatmi.persistence.entities.Pago;

public class EnteCreditoPagarRequest {

	private String cardNumber;
	private String customerId;
	private String businessId;
	private String expirationDate; // 12/2019
	private String securityCode;
	private Float price;
	private Integer Payments;
	private String description;
	
	public EnteCreditoPagarRequest() { }
	
	public EnteCreditoPagarRequest(Pago pago, String cardNumber, String customerId, String bussinesId, String expirationDate,
			String securityCode) {
		this(cardNumber, customerId, bussinesId, expirationDate, securityCode, -pago.getMontoTotal(), 1, "Pago al gimnasio, factura "+pago.getFactura().getId());
	}
	
	public EnteCreditoPagarRequest(String cardNumber, String customerId, String businessId, String expirationDate,
			String securityCode, Float price, Integer Payments, String description) {
		this.cardNumber = cardNumber;
		this.customerId = customerId;
		this.businessId = businessId;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.price = price;
		this.Payments = Payments ;
		this.description=description;
	}

	@Override
	public String toString() {
		return "EnteCreditoPagarRequest [cardNumber=" + cardNumber + ", customerId=" + customerId + ", businessId="
				+ businessId + ", expirationDate=" + expirationDate + ", securityCode=" + securityCode + ", price="
				+ price + ", Payments=" + Payments + ", description=" + description + "]";
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPayments() {
		return Payments;
	}

	public void setPayments(Integer payments) {
		Payments = payments;
	}	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}