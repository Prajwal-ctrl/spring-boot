package com.example.newspring.Newspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newspring.Newspring.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerrepository ;
	
	
	
//	public Integer Calculate(Integer x, Integer  y) {
//		return customerrepository.get_table() ;
//	}
}
