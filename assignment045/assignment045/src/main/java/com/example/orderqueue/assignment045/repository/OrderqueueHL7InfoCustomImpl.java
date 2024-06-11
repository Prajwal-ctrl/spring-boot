package com.example.orderqueue.assignment045.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.orderqueue.assignment045.model.OrderInfo;
import com.example.orderqueue.assignment045.model.OrderQueueModel;
import com.example.orderqueue.assignment045.model.OrderqueueHL7InfoModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Repository
public class OrderqueueHL7InfoCustomImpl implements OrderqueueHL7InfoRepoCustom {
	
	@Autowired
	EntityManager entityManager ;

	@Override
	public OrderQueueModel getprovider(String orderprovider) {
		
			try {
				
				StoredProcedureQuery query  = entityManager.createStoredProcedureQuery("getprovider", OrderQueueModel.class)  ; 
				
				query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN) ; 
				query.setParameter(1, orderprovider) ; 
				return   (OrderQueueModel) query.getSingleResult();
			} catch (Exception e) {
				System.err.println("Exception in getprovider :"+e.getMessage());
			}
		return null;
	}

	
	
	
	@Override
	public OrderQueueModel getinsurancepatient(String insurance, String patientname) {
		try {
			
			StoredProcedureQuery query  = entityManager.createStoredProcedureQuery("getinsurancepatient", OrderQueueModel.class)  ; 
			
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN) ; 
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN) ; 

			
			query.setParameter(1, insurance) ; 
			query.setParameter(2, patientname) ; 
			
			return   (OrderQueueModel) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Exception in getinsurancepatient :"+e.getMessage());
		}
		
		
		return null;
	}

	
	@Override
	public OrderQueueModel getinsurance(String insurance) {
		try {
			
			StoredProcedureQuery query  = entityManager.createStoredProcedureQuery("getinsurance", OrderQueueModel.class) ; 
			
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN) ; 
			query.setParameter(1, insurance) ; 
			query.execute();

			return (OrderQueueModel) query.getSingleResult() ; 
			
		} catch (Exception e) {
			System.out.println("Exception in getinsurance :"+e.getMessage());
		}
		
		return null ; 
	}
	
	@Override
	public OrderInfo updatepractice (String ordercategory,String practicename) {
		try {
			
			StoredProcedureQuery query  = entityManager.createStoredProcedureQuery("updatepractice", OrderInfo.class) ; 
			
			query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN) ; 
			query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN) ; 

			query.setParameter(1, ordercategory) ; 
			query.setParameter(2, practicename) ; 

			return  (OrderInfo) query.getSingleResult() ; 
			
		} catch (Exception e) {
			System.out.println("Exception in getinsurance :"+e.getMessage());
		}
		
	return null ;
	}
	
	
	
	
	
	
	

}
