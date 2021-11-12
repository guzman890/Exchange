package com.bcp.exchange.controller;

import com.bcp.exchange.model.dto.ExchangeRateDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface IExchangeRateController {

	public List<ExchangeRateDTO> getAll();

	public Optional<ExchangeRateDTO> getExchangeRate( Integer id);

	public Optional<ExchangeRateDTO> getExchangeRate( Integer origin,Integer foreign );

	public ExchangeRateDTO save(ExchangeRateDTO currency);

	public boolean delete( Integer id);
}
