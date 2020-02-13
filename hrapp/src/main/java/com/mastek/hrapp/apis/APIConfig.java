package com.mastek.hrapp.apis;





import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

 

import com.mastek.hrapp.services.EmployeeService;

 

@Component 
public class APIConfig  extends ResourceConfig{   // configure the service classes using resourceConfig

	public APIConfig() {
	
		// TODO Auto-generated constructor stub
		register(EmployeeService.class);
	}

}
