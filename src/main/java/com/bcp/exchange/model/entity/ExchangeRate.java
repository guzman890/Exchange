package com.bcp.exchange.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exchangerate")
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Integer id;

	@Column(name= "originid")
	private Integer originId;

	@Column(name= "foreignid")
	private Integer foreignId;

	@Column(name= "rate")
	private Double rate;


	public ExchangeRate(){

	}

	public ExchangeRate(Integer id, Integer originId, Integer foreignId, Double rate) {
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
