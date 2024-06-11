package Timecheck.assignment07._6._4.cutomrepo;


import org.springframework.stereotype.Repository;

import Timecheck.assignment07._6._4.model.OrderModel;

@Repository
public interface OrderdCustomRepo {
	
	

	
	public OrderModel getprovider (String orderprovider) ; 
	
	public OrderModel getinsuranceprovider (String insurance, String patientname ) ; 
	
	public OrderInfo updatepractice (String ordercategory, String practicename) ; 
	
	public OrderModel findorders (String insurance) ;

//	public void startScheduler();
//
//	public void stopScheduler(); 
//	
	public OrderModel order_counts(String orderprovider) ;

	public void reportCurrentTime(); 
	
	public void startScheduler() ;
	
	public OrderModel order_counts () ; 
	
	public void scheduledTask() ;
	
}


