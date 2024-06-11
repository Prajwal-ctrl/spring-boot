package com.example.orderqueue.assignment045.repository;

import org.springframework.stereotype.Repository;

import com.example.orderqueue.assignment045.model.OrderInfo;
import com.example.orderqueue.assignment045.model.OrderQueueModel;

@Repository
public interface OrderqueueHL7InfoRepoCustom {
	
	
	
	public OrderQueueModel getprovider (String orderprovider) ; 
	
	
	public OrderQueueModel getinsurancepatient (String insurance, String patientname) ; 
	
	
	public OrderQueueModel getinsurance (String insurance) ; 
	
    
	public OrderInfo updatepractice (String ordercategory,String practicename) ;
	

}	
