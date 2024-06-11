package com.example.orderqueue.assignment045.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderqueue.assignment045.model.OrderQueueModel;
import com.example.orderqueue.assignment045.repository.OrderQueueRepo;
import com.example.orderqueue.assignment045.repository.OrderQueueRepoCustom;



@RestController 
@RequestMapping("/api/v1")

public class OrderQueueController {
	
	@Autowired
	OrderQueueRepo orderrepo;
	@Autowired 
	OrderQueueRepoCustom orderrepo1 ; 
	
	@Value("${spring.application.name}")
    private String appName;

    @GetMapping("/GetApplicationName")
    public ResponseEntity<String> getApplicationName() {
        return ResponseEntity.ok(appName);
    }
    
   
	@GetMapping ("/GetOrder/{orderid}")
	public OrderQueueModel getordersList (@PathVariable UUID orderid){	
		return  orderrepo1.getorderversion2 (orderid) ; 
	}
	
	
	 
	@DeleteMapping ("/DeleteOrdersByProvider/{orderprovider}")	
	public void deletebyorder (@PathVariable String orderprovider) {
		orderrepo1.deletebyorder (orderprovider) ; 	
	}
	
	
	@GetMapping ("/GetLatestOrder")
	public OrderQueueModel getlatestorder(){
		return orderrepo1.getlatestorder() ; 
	}
	
	
	@GetMapping("/GetOrderDetails/{ordercategory}/{orderprovider}")
	public OrderQueueModel getbyordercategoryList (@PathVariable String ordercategory, @PathVariable String orderprovider){
		return orderrepo1.getordercategoryprovider(ordercategory, orderprovider) ; 
	} 
	
	
    @PostMapping("/SaveOrders")
    public void saveOrders(@RequestBody List<OrderQueueModel> orders) {
    	for (OrderQueueModel order : orders) {
    		orderrepo1.saveallv2(order.getOrderdate(), order.getOrdercategory(), order.getOrderstatus(), order.isIsactive(), order.getOrderprovider(),order.getOrderid());
        }
    	

    }
	
}

















