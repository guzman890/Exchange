package com.bcp.exchange.controller.impl;

import com.bcp.exchange.controller.IExchangeRateController;
import com.bcp.exchange.model.dto.ExchangeRateDTO;
import com.bcp.exchange.service.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/exchangerate")
public class ExchangeRateController implements IExchangeRateController {

	@Autowired
	private IExchangeRateService exchangeRateService;

	@Override
	@GetMapping("")
	public List<ExchangeRateDTO> getAll() {

		return exchangeRateService.getAll();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<ExchangeRateDTO> getExchangeRate(@PathVariable("id") Integer id) {

		return exchangeRateService.getExchangeRate(id);
	}

	@Override
	@PostMapping("")
	public ExchangeRateDTO save(@RequestBody ExchangeRateDTO exchangeRate) {

		return exchangeRateService.save(exchangeRate);
	}

	@Override
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		exchangeRateService.delete(id);
		return true;
	}
}
