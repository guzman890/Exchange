package com.bcp.exchange.repository.impl;

import com.bcp.exchange.model.dto.CurrencyDTO;
import com.bcp.exchange.model.entity.Currency;
import com.bcp.exchange.model.mapper.CurrencyMapper;
import com.bcp.exchange.persistence.CurrencyCrudRepository;
import com.bcp.exchange.repository.ICurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CurrencyRepository implements ICurrencyRepository {

	@Autowired
	private CurrencyCrudRepository currencyCrudRepository;

	@Autowired
	private CurrencyMapper currencyMapper;

	@Override
	public List<CurrencyDTO> getAll() {

		return currencyMapper.toCurrencyDTOs((List<Currency>) currencyCrudRepository.findAll());
	}

	@Override
	public Optional<CurrencyDTO> getCurrency(Integer idCurrency) {

		Optional<Currency> oCurrency =  currencyCrudRepository.findById(idCurrency);
		if(!oCurrency.isPresent()){
			return Optional.empty();
		}
		return Optional.of( currencyMapper.toCurrencyDTO( oCurrency.get() ) );
	}

	@Override
	public Optional<CurrencyDTO> getCurrencyBySymbol(String symbol) {

		Currency currency = currencyCrudRepository.findBySymbol(symbol);

		if(Objects.isNull(currency)){
			return Optional.empty();
		}
		return Optional.of( currencyMapper.toCurrencyDTO( currency ) );
	}

	@Override
	public CurrencyDTO save(CurrencyDTO currencyDTO) {
		return currencyMapper.toCurrencyDTO(currencyCrudRepository.save( currencyMapper.toCurrency(currencyDTO)));
	}

	@Override
	public void delete(int idCurrency) {
		currencyCrudRepository.deleteById(idCurrency);
	}
}
