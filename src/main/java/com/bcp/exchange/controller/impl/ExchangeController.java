package com.bcp.exchange.controller.impl;

import com.bcp.exchange.common.Errors;
import com.bcp.exchange.common.Validate;
import com.bcp.exchange.controller.IExchangeController;
import com.bcp.exchange.model.dto.ExchangeRequestDTO;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;
import com.bcp.exchange.service.IExchangeService;
import com.bcp.exchange.service.impl.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exchange")
public class ExchangeController implements IExchangeController {

	@Autowired
	private IExchangeService exchangeService;

	@Override
	@PostMapping("")
	public ExchangeResponseDTO exchangeMoney(@RequestBody ExchangeRequestDTO exchangeRequestDTO) throws Exception{

		if( !Validate.validateExchangeRequestDTO(exchangeRequestDTO) ){
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, Errors.REQUEST.getValue());
		}
		return exchangeService.exchangeMoney(exchangeRequestDTO);
	}
}
