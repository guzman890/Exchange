package com.bcp.exchange.persistence;

import com.bcp.exchange.model.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeRateCrudRepository extends CrudRepository<ExchangeRate,Integer> {
	ExchangeRate findByOriginAndForeign(Integer origin, Integer foreign);
}
