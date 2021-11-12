package com.bcp.exchange.model.dto;


public class ExchangeRateDTO {

	private Integer id;

	private Integer originId;

	private Integer foreignId;

	private Double rate;


	public ExchangeRateDTO(){

	}

	public ExchangeRateDTO(Integer id, Integer originId, Integer foreignId, Double rate) {
		this.id = id;
		this.originId = originId;
		this.foreignId = foreignId;
		this.rate = rate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOriginId() {
		return originId;
	}

	public void setOriginId(Integer originCurrencyId) {
		this.originId = originCurrencyId;
	}

	public Integer getForeignId() {
		return foreignId;
	}

	public void setForeignId(Integer foreignCurrencyId) {
		this.foreignId = foreignCurrencyId;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
}
