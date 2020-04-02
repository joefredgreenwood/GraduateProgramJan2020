package com.mastek.bank.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.bank.services.BankServices;


@Component
public class APIConfig extends ResourceConfig{
	
	public APIConfig() {
		
		// TODO Auto-generated constructor stub
		register(BankServices.class);
		register(CORSFilter.class);
	}

}
