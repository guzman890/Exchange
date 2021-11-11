package com.bcp.exchange.service;

import com.bcp.exchange.model.dto.ExchangeRequestDTO;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;

public interface IExchangeService {

	public ExchangeResponseDTO exchangeMoney(ExchangeRequestDTO exchangeRequestDTO);
}
