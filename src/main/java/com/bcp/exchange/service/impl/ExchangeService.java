package com.bcp.exchange.service.impl;

import com.bcp.exchange.model.dto.ExchangeRequestDTO;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;
import com.bcp.exchange.model.entity.Currency;
import com.bcp.exchange.model.entity.ExchangeRate;
import com.bcp.exchange.repository.ICurrencyRepository;
import com.bcp.exchange.repository.IExchangeRateRepository;
import com.bcp.exchange.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class ExchangeService implements IExchangeService {

	@Autowired
	private ICurrencyRepository currencyRepository;

	@Autowired
	private IExchangeRateRepository exchangeRateRepository;

	@Override
	public ExchangeResponseDTO exchangeMoney(ExchangeRequestDTO exchangeRequestDTO) {

		ExchangeResponseDTO response =  new ExchangeResponseDTO();

		response.setAmount(exchangeRequestDTO.getAmount());
		response.setForeignCurrency(exchangeRequestDTO.getForeignCurrency());
		response.setOriginCurrency(exchangeRequestDTO.getOriginCurrency());

		Currency originCurrency;
		Optional<Currency> oOriginCurrency = currencyRepository.getCurrencyBySymbol( exchangeRequestDTO.getOriginCurrency() );
		if(oOriginCurrency.isPresent()){
			originCurrency = oOriginCurrency.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"");
		}

		Currency foreignCurrency;
		Optional<Currency> oForeignCurrency = currencyRepository.getCurrencyBySymbol( exchangeRequestDTO.getForeignCurrency() );
		if(oForeignCurrency.isPresent()){
			foreignCurrency = oForeignCurrency.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"");
		}

		ExchangeRate exchangeRate;
		Optional<ExchangeRate> oExchangeRate= exchangeRateRepository.getExchangeRateByOriginAndForeign(originCurrency.getId(),foreignCurrency.getId());
		if( oExchangeRate.isPresent()){
			exchangeRate = oExchangeRate.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"");
		}

		response.setAmountExchange( response.getAmount()*exchangeRate.getRate() );

		return response;
	}
}
