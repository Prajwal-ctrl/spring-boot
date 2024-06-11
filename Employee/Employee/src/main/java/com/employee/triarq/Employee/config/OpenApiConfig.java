package com.employee.triarq.Employee.config;

import org.springframework.context.annotation.Description;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition (
		
		
	info = @Info	(
			
		title = "Employee API", 
		description =  "CRUD & REST API Operations", 
		summary =  "This is Employee-API will add, delete, create & update", 
		termsOfService =  "T&C", 
		contact =  @Contact(
				name = "Triarq", 
				email =  "someting@gmail.com"
	     ), 
		 
		license =  @License (
				name = "License Info"
		), 
		
		version =  "v1"
		
	), 

	servers =  {
			
			@Server(
					description =  "DEV",
					url = "https://localhost:8080"
				), 
			@Server(
					description =  "Test",
					url = "https://localhost:8080"
				), 
			
			
	}
	
		
)




public class OpenApiConfig {

	

 }
