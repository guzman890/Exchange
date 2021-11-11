package com.bcp.exchange.controller.impl;

import com.bcp.exchange.controller.IExchangeController;
import com.bcp.exchange.model.dto.ExchangeResponseDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exchange")
public class ExchangeController implements IExchangeController {

	@Override
	@PostMapping("")
	public ExchangeResponseDTO exchangeMoney(ExchangeResponseDTO exchangeResponseDTO) {
		return null;
	}
}
