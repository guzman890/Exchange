package com.bcp.exchange.service.impl;

import com.bcp.exchange.model.dto.CurrencyDTO;
import com.bcp.exchange.model.dto.ExchangeRateDTO;
import com.bcp.exchange.model.dto.ExchangeRequestDTO;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;
import com.bcp.exchange.repository.ICurrencyRepository;
import com.bcp.exchange.repository.IExchangeRateRepository;
import com.bcp.exchange.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import rx.Observable;
import rx.Single;
import rx.Subscriber;
import rx.schedulers.Schedulers;

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

		Observable<CurrencyDTO> a = Observable.just(getCurrency(exchangeRequestDTO.getOriginCurrency()))
						.subscribeOn(Schedulers.newThread());
		Observable<CurrencyDTO> b = Observable.just( getCurrency(exchangeRequestDTO.getForeignCurrency()))
						.subscribeOn(Schedulers.newThread());

		ExchangeRateDTO exchangeRate  = Observable.zip(a,b,this::getExchangeRate).toBlocking().first();

		response.setAmountExchange( response.getAmount()*exchangeRate.getRate() );

		return response;
	}

	private CurrencyDTO getCurrency(String symbol){
		Optional<CurrencyDTO> oOriginCurrency = currencyRepository.getCurrencyBySymbol( symbol );
		if(oOriginCurrency.isPresent()){
			return oOriginCurrency.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"");
		}
	}

	private ExchangeRateDTO getExchangeRate(CurrencyDTO origin, CurrencyDTO foreign){
		Optional<ExchangeRateDTO> oExchangeRate= exchangeRateRepository.getExchangeRateByOriginAndForeign(origin.getId(),foreign.getId());
		if( oExchangeRate.isPresent()){
			return oExchangeRate.get();
		}else{
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"");
		}
	}
}
