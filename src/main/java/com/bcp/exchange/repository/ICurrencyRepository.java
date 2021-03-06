package com.bcp.exchange.repository;

import com.bcp.exchange.model.dto.CurrencyDTO;
import java.util.List;
import java.util.Optional;

public interface ICurrencyRepository {

	List<CurrencyDTO> getAll();
	Optional<CurrencyDTO> getCurrency(Integer id);
	Optional<CurrencyDTO> getCurrencyBySymbol(String symbol);
	CurrencyDTO save(CurrencyDTO currency);
	void  delete(int id);
}
