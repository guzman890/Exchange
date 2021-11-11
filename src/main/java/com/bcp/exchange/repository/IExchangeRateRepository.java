package com.bcp.exchange.repository;

import com.bcp.exchange.model.entity.Currency;
import com.bcp.exchange.model.entity.ExchangeRate;

import java.util.List;
import java.util.Optional;

public interface IExchangeRateRepository {

	List<ExchangeRate> getAll();
	Optional<ExchangeRate> getExchangeRate(Integer id);
	Optional<ExchangeRate> getExchangeRateByOriginAndForeign(Integer origin, Integer foreign);
	ExchangeRate save(ExchangeRate exchangeRate);
	void  delete(int id);

}
