package com.example.orderqueue.assignment045.repository;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.orderqueue.assignment045.model.OrderQueueModel;



@Repository
public interface OrderQueueRepoCustom  {

	public OrderQueueModel getorderversion2 (UUID orderid)  ;

	public OrderQueueModel getlatestorder () ; 
	
	public void deletebyorder(String orderprovider) ; 
	
	public OrderQueueModel getordercategoryprovider (String ordercategory, String orderprovider)  ;
	
	public void saveallv2(OffsetDateTime orderdate, String ordercategory, String orderstatus, boolean isactive,String orderprovider, UUID orderid);
	
//	public void saveall(Object order);

}
