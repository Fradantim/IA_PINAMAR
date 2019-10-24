package com.ia.tmi.iatmi.remoteEndpoint.entidadCreditoEndpoint;

public class Cuota {
	private Long customerId; 
	private String cardNumber; 
	private String businessId; 
	private String date;
	private Float Price;
	
	public Cuota() { }
	
	public Cuota(Long customerId, String cardNumber, String businessId, String date, Float Price) {
		this.customerId = customerId;
		this.cardNumber = cardNumber;
		this.businessId = businessId;
		this.date = date;
		this.Price = Price;
	}
		
	@Override
	public String toString() {
		return "Cuota [customerId=" + customerId + ", cardNumber=" + cardNumber + ", businessId=" + businessId
				+ ", date=" + date + ", Price=" + Price + "]";
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getPrice() {
		return Price;
	}

	public void setPrice(Float price) {
		Price = price;
	}
}