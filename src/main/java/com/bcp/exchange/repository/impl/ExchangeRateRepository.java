package com.bcp.exchange.repository.impl;

import com.bcp.exchange.model.dto.ExchangeRateDTO;
import com.bcp.exchange.model.entity.Currency;
import com.bcp.exchange.model.entity.ExchangeRate;
import com.bcp.exchange.model.mapper.ExchangeRateMapper;
import com.bcp.exchange.persistence.ExchangeRateCrudRepository;
import com.bcp.exchange.repository.IExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ExchangeRateRepository implements IExchangeRateRepository {

	@Autowired
	private ExchangeRateCrudRepository exchangeRateCrudRepository;

	@Autowired
	private ExchangeRateMapper exchangeRateMapper;

	@Override
	public List<ExchangeRateDTO> getAll() {

		return exchangeRateMapper.toExchangeRateDTOs((List<ExchangeRate>)  exchangeRateCrudRepository.findAll());
	}

	@Override
	public Optional<ExchangeRateDTO> getExchangeRate(Integer id) {

		Optional<ExchangeRate> oExchangeRate = exchangeRateCrudRepository.findById(id);
		if(!oExchangeRate.isPresent()){
			return Optional.empty();
		}
		return Optional.of( exchangeRateMapper.toExchangeRateDTO( oExchangeRate.get() ) );
	}

	@Override
	public Optional<ExchangeRateDTO> getExchangeRateByOriginAndForeign(Integer origin, Integer foreign) {
		ExchangeRate exchangeRate = exchangeRateCrudRepository.findByOriginIdAndForeignId(origin,foreign);

		if(exchangeRate == null){
			return Optional.empty();
		}
		return Optional.of( exchangeRateMapper.toExchangeRateDTO(exchangeRate) );
	}

	@Override
	public ExchangeRateDTO save(ExchangeRateDTO exchangeRate) {

		ExchangeRate exchangeRateSaved = exchangeRateCrudRepository.save(exchangeRateMapper.toExchangeRate(exchangeRate));

		return exchangeRateMapper.toExchangeRateDTO( exchangeRateSaved ) ;
	}

	@Override
	public void delete(int idExchangeRate) {
		exchangeRateCrudRepository.deleteById(idExchangeRate);
	}
}
