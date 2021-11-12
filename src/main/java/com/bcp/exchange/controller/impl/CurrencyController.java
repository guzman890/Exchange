package com.bcp.exchange.controller.impl;

import com.bcp.exchange.controller.ICurrencyController;
import com.bcp.exchange.model.dto.CurrencyDTO;
import com.bcp.exchange.service.ICurrencyService;
import com.bcp.exchange.service.IExchangeService;
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
@RequestMapping("/currency")
public class CurrencyController implements ICurrencyController {

	@Autowired
	private ICurrencyService currencyService;

	@Override
	@GetMapping("")
	public List<CurrencyDTO> getAll() {
		return currencyService.getAll();
	}

	@Override
	@GetMapping("/{id}")
	public Optional<CurrencyDTO> getCurrency(@PathVariable("id") Integer id) {
		return currencyService.getCurrency(id);
	}

	@Override
	@PostMapping("")
	public CurrencyDTO save(@RequestBody CurrencyDTO currency) {
		return currencyService.save(currency);
	}

	@Override
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable("id") Integer id) {
		currencyService.delete(id);
		return true;
	}
}
