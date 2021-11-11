package com.bcp.exchange.repository.impl;

import com.bcp.exchange.model.entity.Currency;
import com.bcp.exchange.persistence.CurrencyCrudRepository;
import com.bcp.exchange.repository.ICurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CurrencyRepository implements ICurrencyRepository {

	@Autowired
	private CurrencyCrudRepository currencyCrudRepository;

	@Override
	public List<Currency> getAll() {
		return (List<Currency>) currencyCrudRepository.findAll();
	}

	@Override
	public Optional<Currency> getCurrency(Integer idCurrency) {
		return currencyCrudRepository.findById(idCurrency);
	}

	@Override
	public Optional<Currency> getCurrencyBySymbol(String symbol) {
		Currency currency = currencyCrudRepository.findBySymbol(symbol);

		if(currency == null){
			return Optional.empty();
		}
		return Optional.of(currency);
	}

	@Override
	public Currency save(Currency currency) {
		return currencyCrudRepository.save(currency);
	}

	@Override
	public void delete(int idCurrency) {
		currencyCrudRepository.deleteById(idCurrency);
	}
}
