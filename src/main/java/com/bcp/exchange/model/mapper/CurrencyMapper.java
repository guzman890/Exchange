package com.bcp.exchange.model.mapper;

import com.bcp.exchange.model.dto.CurrencyDTO;
import com.bcp.exchange.model.entity.Currency;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
	@Mappings(
		{
			@Mapping(source="id", target = "id" ),
			@Mapping(source="symbol", target = "symbol" )
		}
	)

	CurrencyDTO toCurrencyDTO(Currency currency);
	List<CurrencyDTO> toCurrencyDTOs(List<Currency> currencys);

	@InheritInverseConfiguration
	Currency toCurrency(CurrencyDTO currencyDTO);
}
