package com.bcp.exchange.controller;

import com.bcp.exchange.model.dto.ExchangeRateDTO;
import java.util.List;
import java.util.Optional;

public interface IExchangeRateController {

	public List<ExchangeRateDTO> getAll();

	public Optional<ExchangeRateDTO> getExchangeRate( Integer id);

	public ExchangeRateDTO save(ExchangeRateDTO currency);

	public boolean delete( Integer id);
}
