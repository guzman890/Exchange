package com.bcp.exchange.model.dto;

public class ExchangeResponseDTO {
	private Double amount;
	private String originCurrency;
	private String foreignCurrency;
	private Double amountExchange;

	public ExchangeResponseDTO(){

	}

	public ExchangeResponseDTO(Double amount, String originCurrency, String foreignCurrency, Double amountExchange) {
		this.amount = amount;
		this.originCurrency = originCurrency;
		this.foreignCurrency = foreignCurrency;
		this.amountExchange = amountExchange;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getOriginCurrency() {
		return originCurrency;
	}

	public void setOriginCurrency(String originCurrency) {
		this.originCurrency = originCurrency;
	}

	public String getForeignCurrency() {
		return foreignCurrency;
	}

	public void setForeignCurrency(String foreignCurrency) {
		this.foreignCurrency = foreignCurrency;
	}

	public Double getAmountExchange() {
		return amountExchange;
	}

	public void setAmountExchange(Double amountExchange) {
		this.amountExchange = amountExchange;
	}
}
