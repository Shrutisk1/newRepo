package com.bikkadit.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bikkadit.currencyconversion.model.CurrencyConversion;

@RestController
public class CurrencyController {
	
	
	@GetMapping("/currencyconversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
		
		HashMap<String, String> uriVariable=new HashMap<>();
		uriVariable.put("from",from);
		uriVariable.put("to", to);
		
		
		ResponseEntity<CurrencyConversion> forEntity = restTemplate.getForEntity("http://localhost:8787/currencyexchange/from/USD/to/INR", CurrencyConversion.class,uriVariable);
		CurrencyConversion conversion = forEntity.getBody();
		
		CurrencyConversion totalConversion = new CurrencyConversion(conversion.getId(),from, to,
				                         quantity, conversion.getConversionMultiple(),
				                         quantity.multiply(conversion.getConversionMultiple()),
				                         conversion.getEnv());
		
		return totalConversion;
		
	}
	

}
