package com.example.orderqueue.assignment045.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderqueue.assignment045.model.OrderInfo;
import com.example.orderqueue.assignment045.model.OrderQueueModel;
import com.example.orderqueue.assignment045.repository.OrderqueueHL7InfoRepoCustom;

@RestController
@RequestMapping ("/api/v1")

public class OrderqueueHL7InfoController {
	
	@Autowired
	OrderqueueHL7InfoRepoCustom customrepo;
	OrderInfo orderinfo;
	
	
	
	@GetMapping ("/allorders/{orderprovider}")
	public OrderQueueModel getallprovidersController (@PathVariable String orderprovider) {
		return customrepo.getprovider(orderprovider) ; 
	}
	
	@GetMapping("/findOrders/{insurance}")
	public OrderQueueModel findinsurance(@PathVariable String insurance) {
		return customrepo.getinsurance(insurance) ;
	}
	
	
	@GetMapping("/allorders/{insurance}/{patientname}")
	public OrderQueueModel getinsurancepatientdata (@PathVariable String insurance, @PathVariable String patientname) {
		return customrepo.getinsurancepatient(insurance, patientname) ;
	}
	
	
	@PutMapping ("/UpdatePractice/{ordercategory}")
	public OrderInfo updatepraticebyprovider (@RequestBody OrderInfo orderinfo) {
		return customrepo.updatepractice(orderinfo.getOrdercategory(),orderinfo.getPracticename()) ;
	}
	
}

