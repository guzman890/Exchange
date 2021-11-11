package com.bcp.exchange.persistence;

import com.bcp.exchange.model.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyCrudRepository extends CrudRepository<Currency,Integer> {

	Currency findBySymbol(String symbol);
}
