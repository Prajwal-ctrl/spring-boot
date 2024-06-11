package com.employee.triarq.Employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



//How the Java spring boot JPA & Database works 
//HTTP Request -> Controller -> Service -> Repository -> Database
//HTTP Request -> Controller -> Service -> Repository -> Exception -> Exception Handler





//Main SpringBoot Application & adding swagger to it. 
//@EnableSwagger2
@SpringBootApplication



public class SpringDataJpaMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaMappingsApplication.class, args);
	}

}




