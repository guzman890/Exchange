package com.bcp.exchange.repository.impl;

import com.bcp.exchange.model.entity.Currency;
import com.bcp.exchange.model.entity.ExchangeRate;
import com.bcp.exchange.persistence.ExchangeRateCrudRepository;
import com.bcp.exchange.repository.IExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class ExchangeRateRepository implements IExchangeRateRepository {

	@Autowired
	private ExchangeRateCrudRepository exchangeRateCrudRepository;

	@Override public List<ExchangeRate> getAll() {
		return (List<ExchangeRate>) exchangeRateCrudRepository.findAll();
	}

	@Override public Optional<ExchangeRate> getExchangeRate(Integer id) {
		return exchangeRateCrudRepository.findById(id);
	}

	@Override public Optional<ExchangeRate> getExchangeRateByOriginAndForeign(Integer origin, Integer foreign) {
		ExchangeRate exchangeRate = exchangeRateCrudRepository.findByOriginAndForeign(origin,foreign);

		if(exchangeRate == null){
			return Optional.empty();
		}
		return Optional.of(exchangeRate);
	}

	@Override public ExchangeRate save(ExchangeRate currency) {
		return null;
	}

	@Override public void delete(int id) {

	}
}
