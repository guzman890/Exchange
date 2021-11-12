package com.bcp.exchange.service.impl;

import com.bcp.exchange.model.dto.CurrencyDTO;
import com.bcp.exchange.repository.ICurrencyRepository;
import com.bcp.exchange.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService implements ICurrencyService {

	@Autowired
	private ICurrencyRepository currencyRepository;

	@Override
	public List<CurrencyDTO> getAll() {

		return currencyRepository.getAll();
	}

	@Override
	public Optional<CurrencyDTO> getCurrency(Integer id) {

		return currencyRepository.getCurrency(id);
	}

	@Override
	public Optional<CurrencyDTO> getCurrencyBySymbol(String symbol) {

		return currencyRepository.getCurrencyBySymbol(symbol);
	}

	@Override
	public CurrencyDTO save(CurrencyDTO currency) {

		return currencyRepository.save(currency);
	}

	@Override
	public void delete(int id) {

		currencyRepository.delete(id);
	}

}
