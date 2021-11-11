package com.bcp.exchange.repository;

import com.bcp.exchange.model.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface ICurrencyRepository {

	List<Currency> getAll();
	Optional<Currency> getCurrency(Integer id);
	Optional<Currency> getCurrencyBySymbol(String symbol);
	Currency save(Currency currency);
	void  delete(int id);
}
