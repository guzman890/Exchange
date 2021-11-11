package com.bcp.exchange.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;

	@Column(name= "origin")
	private Integer originCurrencyId;

	@Column(name= "foreign")
	private Integer foreignCurrencyId;

	@Column(name= "rate")
	private Double rate;


	public ExchangeRate(){

	}

	public ExchangeRate(Integer id, Integer originCurrencyId, Integer foreignCurrencyId, Double buying, Double selling) {
		this.id = id;
		this.originCurrencyId = originCurrencyId;
		this.foreignCurrencyId = foreignCurrencyId;
		this.rate = rate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOriginCurrencyId() {
		return originCurrencyId;
	}

	public void setOriginCurrencyId(Integer originCurrencyId) {
		this.originCurrencyId = originCurrencyId;
	}

	public Integer getForeignCurrencyId() {
		return foreignCurrencyId;
	}

	public void setForeignCurrencyId(Integer foreignCurrencyId) {
		this.foreignCurrencyId = foreignCurrencyId;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}
}
