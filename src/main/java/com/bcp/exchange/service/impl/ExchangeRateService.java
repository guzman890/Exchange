package com.bcp.exchange.service.impl;

import com.bcp.exchange.model.dto.ExchangeRateDTO;
import com.bcp.exchange.repository.IExchangeRateRepository;
import com.bcp.exchange.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateService implements IExchangeRateService {

	@Autowired
	private IExchangeRateRepository exchangeRateRepository;

	@Override
	public List<ExchangeRateDTO> getAll() {
		return exchangeRateRepository.getAll();
	}

	@Override
	public Optional<ExchangeRateDTO> getExchangeRate(Integer id) {
		return exchangeRateRepository.getExchangeRate(id);
	}

	@Override
	public Optional<ExchangeRateDTO> getExchangeRateByOriginAndForeign(Integer origin, Integer foreign) {
		return exchangeRateRepository.getExchangeRateByOriginAndForeign(origin, foreign);
	}

	@Override
	public ExchangeRateDTO save(ExchangeRateDTO exchangeRate) {
		return exchangeRateRepository.save(exchangeRate);
	}

	@Override
	public void delete(int id) {
		exchangeRateRepository.delete(id);
	}
}
