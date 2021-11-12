package com.bcp.exchange.model.dto;


public class CurrencyDTO {

	private Integer id;

	private String symbol;

	public CurrencyDTO(){

	}

	public CurrencyDTO(Integer id, String symbol) {
		this.id = id;
		this.symbol = symbol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
