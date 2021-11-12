package com.bcp.exchange.controller;

import com.bcp.exchange.model.dto.CurrencyDTO;
import java.util.List;
import java.util.Optional;

public interface ICurrencyController {

	public List<CurrencyDTO> getAll();

	public Optional<CurrencyDTO> getCurrency( Integer id);

	public CurrencyDTO save(CurrencyDTO currency);

	public boolean delete( Integer id);

}
