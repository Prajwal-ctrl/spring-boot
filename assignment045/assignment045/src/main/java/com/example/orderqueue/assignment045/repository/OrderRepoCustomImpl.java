package com.example.orderqueue.assignment045.repository;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.orderqueue.assignment045.model.OrderQueueModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;


@Repository
public class OrderRepoCustomImpl implements OrderQueueRepoCustom {
	
	@Autowired
	EntityManager entityManager;
	
//GetOrderByID:
	@Override
	public OrderQueueModel getorderversion2(UUID orderid) {
      
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getorderversion2", OrderQueueModel.class);
            
            query.registerStoredProcedureParameter(1, UUID.class, ParameterMode.IN);
            query.setParameter(1, orderid);  
            return (OrderQueueModel) query.getSingleResult() ; 
	        
            
        } catch (Exception e) {
            System.out.println("Exception in getOrderVersion2: " + e.getMessage());
        }
		return null; 
       
    }


	
//second function:delete
	@Override
	public void deletebyorder (String orderprovider) {
		try {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("deletebyorder", OrderQueueModel.class) ; 
		
		query.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
        
        query.setParameter(1, orderprovider);
        
		query.getSingleResult()  ; 
		System.out.println("Record deleted Successfully") ; 
	}catch (Exception e) {
		System.out.println("Exception in delete" + e.getMessage()) ; 
	}
}
	
	
//Third function: GetLatestOrder	
	@Override
	public OrderQueueModel getlatestorder(){
		
		try {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getlatestorder", OrderQueueModel.class);
		return (OrderQueueModel) query.getSingleResult() ; 		

		} catch (Exception e) {
			System.out.println("Exception in get latest order:"+e.getMessage());
		}
		return null; 
		
	}
	
//Fourth Function:/GetOrderDetails/{ordercategory}/{orderprovider}
	@Override
	public OrderQueueModel getordercategoryprovider (String ordercategory, String orderprovider){
		
		try {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getordercategoryprovider", OrderQueueModel.class) ; 
			
			query.registerStoredProcedureParameter(1, String.class,ParameterMode.IN) ;  
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN) ;
			
			
			query.setParameter(1, ordercategory) ; 
			query.setParameter(2, orderprovider) ; 
			
			return (OrderQueueModel) query.getSingleResult() ; 
			
		
	   }catch (Exception e) {
		System.out.println("Exception in get by order category List:"+e.getMessage());
	}
		return null;
}
	
	
//Fifth Call: 
	 public void saveallv2(OffsetDateTime orderdate, String ordercategory, String orderstatus, boolean isactive,String orderprovider, UUID orderid) {
		 
		 try {
				StoredProcedureQuery query = entityManager.createStoredProcedureQuery("saveallv2", OrderQueueModel.class) ; 
				
				query.registerStoredProcedureParameter(1, java.time.OffsetDateTime.class,ParameterMode.IN) ;  
				query.registerStoredProcedureParameter(2, String.class,ParameterMode.IN) ;  
				query.registerStoredProcedureParameter(3, String.class,ParameterMode.IN) ;  
				query.registerStoredProcedureParameter(4, boolean.class,ParameterMode.IN) ;  
				query.registerStoredProcedureParameter(5, String.class,ParameterMode.IN) ;  
				query.registerStoredProcedureParameter(6, UUID.class,ParameterMode.IN) ;  


				query.setParameter(1, orderdate) ;	
				query.setParameter(2, ordercategory) ;	
				query.setParameter(3, orderstatus) ;	
				query.setParameter(4, isactive) ;	
				query.setParameter(5, orderprovider) ;				
				query.setParameter(6, orderid) ;				

				
			    query.getSingleResult();

		   }catch (Exception e) {
			System.out.println("Exception in get by order category List:"+e.getMessage());
		}
	 }
	

}



























