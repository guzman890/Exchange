package com.bcp.exchange.common;

import com.bcp.exchange.model.dto.ExchangeRequestDTO;

import java.util.Objects;

public class Validate {
	public static boolean validateExchangeRequestDTO(ExchangeRequestDTO exchangeRequestDTO){
		if( NullOrEmpty(exchangeRequestDTO.getForeignCurrency()) ){
			return false;
		}

		if( NullOrEmpty(exchangeRequestDTO.getOriginCurrency()) ){
			return false;
		}

		if( NullOrInvalidValue(exchangeRequestDTO.getAmount())){
			return false;
		}
		return true;
	}

	private static boolean NullOrEmpty(String value){
		if( Objects.isNull(value) ){
			return true;
		}

		if( value.equals(Constant.EMPTY) ){
			return true;
		}
		return false;
	}

	private static boolean NullOrInvalidValue(Double value){
		if( Objects.isNull(value) ){
			return true;
		}
		if( value.compareTo(Constant.ZERO) <= Constant.ONE){
			return true;
		}
		return false;
	}
}
