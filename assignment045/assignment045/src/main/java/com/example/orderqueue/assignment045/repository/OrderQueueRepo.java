package com.example.orderqueue.assignment045.repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.orderqueue.assignment045.model.OrderQueueModel;

@Repository
public interface OrderQueueRepo extends JpaRepository<OrderQueueModel, UUID> {
	
//
	@Query (value = "SELECT * FROM getorder(:orderid)", nativeQuery =  true)
	public List<Object[]> getorder(UUID orderid) ;
	
	
//use to call stored procedures 
//	@Procedure (procedureName = "getorder")
//	public List<Object[]> procgetorder(UUID orderid) ;
	
	
	@Query(value =  "SELECT *FROM deletebyorder(:orderprovider)", nativeQuery =  true)
	public void deletbyorder (String  orderprovider) ; 
	
	@Query (value =  "SELECT *FROM GetLatestOrder ()", nativeQuery = true)
	public List<Object[]> getlatestorder() ; 
	
	
	@Query (value = "SELECT *FROM getordercategoryprovider (:ordercategory, :orderprovider)", nativeQuery = true)
	public List<Object[]> getbyordercategory (String ordercategory, String orderprovider) ; 
	
	@Query (value = "SELECT *FROM saveall(:orderdate,:ordercategory,:orderstatus,:isactive :orderprovider)", nativeQuery = true)
	public static void saveall (OffsetDateTime orderdate , String ordercategory, String orderstatus, boolean isactive, String orderprovider) {
		
	}
	
	
}
