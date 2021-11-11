package com.bcp.exchange.common;

public enum Errors {

	REQUEST("No Valid Exchange Request was recieved");

	private String Value;

	private Errors(String s) {

	}

	public String getValue() {
		return Value;
	}

}
