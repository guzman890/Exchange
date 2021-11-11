package com.bcp.exchange.model.dto;

public class ExchangeRequestDTO {
	private Double amount;
	private String originCurrency;
	private String foreignCurrency;

	public ExchangeRequestDTO() {

	}

	public ExchangeRequestDTO(Double amount, String originCurrency, String foreignCurrency) {
		this.amount = amount;
		this.originCurrency = originCurrency;
		this.foreignCurrency = foreignCurrency;
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
}
