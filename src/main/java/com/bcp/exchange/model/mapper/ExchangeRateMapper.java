package com.bcp.exchange.model.mapper;

import com.bcp.exchange.model.dto.ExchangeRateDTO;
import com.bcp.exchange.model.entity.ExchangeRate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExchangeRateMapper {
	@Mappings(
		{
			@Mapping(source="id", target = "id" ),
			@Mapping(source="originId", target = "originId" ),
			@Mapping(source="foreignId", target = "foreignId" ),
			@Mapping(source="rate", target = "rate" )
		}
	)
	ExchangeRateDTO toExchangeRateDTO(ExchangeRate exchangeRate);
	List<ExchangeRateDTO> toExchangeRateDTOs(List<ExchangeRate> exchangeRate);

	@InheritInverseConfiguration
	ExchangeRate toExchangeRate(ExchangeRateDTO exchangeRateDTO);

}
