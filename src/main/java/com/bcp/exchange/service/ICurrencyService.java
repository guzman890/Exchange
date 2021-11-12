package com.bcp.exchange.service;

import com.bcp.exchange.model.dto.CurrencyDTO;
import java.util.List;
import java.util.Optional;

public interface ICurrencyService {

	List<CurrencyDTO> getAll();
	Optional<CurrencyDTO> getCurrency(Integer id);
	Optional<CurrencyDTO> getCurrencyBySymbol(String symbol);
	CurrencyDTO save(CurrencyDTO currencyDTO);
	void  delete(int id);
}
