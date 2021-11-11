package com.bcp.exchange.service.impl;

import com.bcp.exchange.model.dto.ExchangeRequestDTO;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;
import com.bcp.exchange.service.IExchangeService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService implements IExchangeService {

	@Override
	public ExchangeResponseDTO exchangeMoney(ExchangeRequestDTO exchangeRequestDTO) {

		ExchangeResponseDTO response =  new ExchangeResponseDTO();

		response.setAmount(exchangeRequestDTO.getAmount());
		response.setForeignCurrency(exchangeRequestDTO.getForeignCurrency());
		response.setOriginCurrency(exchangeRequestDTO.getOriginCurrency());

		return response;
	}
}
