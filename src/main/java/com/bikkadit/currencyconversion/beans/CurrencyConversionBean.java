package com.bikkadit.currencyconversion.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.client.RestTemplate;

@
@EnableDiscoveryClient
public class CurrencyConversionBean {
	
	@Autowired
	public RestTemplate restTemplate;
	
	


	}



}
