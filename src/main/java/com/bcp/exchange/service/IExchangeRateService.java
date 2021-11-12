package com.bcp.exchange.service;

import com.bcp.exchange.model.dto.ExchangeRateDTO;
import java.util.List;
import java.util.Optional;

public interface IExchangeRateService  {
	List<ExchangeRateDTO> getAll();
	Optional<ExchangeRateDTO> getExchangeRate(Integer id);
	Optional<ExchangeRateDTO> getExchangeRateByOriginAndForeign(Integer origin, Integer foreign);
	ExchangeRateDTO save(ExchangeRateDTO exchangeRate);
	void  delete(int id);
}
