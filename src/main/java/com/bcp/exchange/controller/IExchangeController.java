package com.bcp.exchange.controller;

import com.bcp.exchange.model.dto.ExchangeRequestDTO;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;

public interface IExchangeController {

	public ExchangeResponseDTO exchangeMoney(ExchangeRequestDTO exchangeRequestDTO) throws Exception;
}
