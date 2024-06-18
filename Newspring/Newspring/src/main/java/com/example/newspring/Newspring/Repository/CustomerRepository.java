package com.example.newspring.Newspring.Repository; 

import java.util.List;

import org.apache.catalina.util.CustomObjectInputStream;
import org.hibernate.type.TrueFalseConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.newspring.Newspring.model.CustomerModel;

import jakarta.persistence.Id;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.transaction.Transactional;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{
	
// Using functions from database side & getting them in repo & calling in controller side. 	
	

// if we remove nativeQuery = true from query then it will be treated as JPQL queries
//JPQL operates on java entities not on database tables independent of database; 
//@Query annotation supports both JPQL & Native queries 
    	

//	@Query(value = "SELECT * FROM gettable()", nativeQuery = true)
//   List<Object[]> gettable();
//   
//    @Query(value = "SELECT * FROM customer_by_id(:customerId)", nativeQuery = true)
//    List<Object[]> customer_by_id(Long customerId);

//    @Query(value = "SELECT* FROM save_customer (:customerName, :emailId)", nativeQuery = true )
//    public CustomerModel save_customer(String customerName, String emailId);
    	
    
//    @Query (value =  "SELECT *FROM delete_customer(:customerID) ", nativeQuery = true )
//    void delete_customer(Long customerID) ; 
    	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
 // Custom Query using query directly in @Query annotations 
    
    
   @Query (value = "SELECT *FROM customer", nativeQuery =  true)
   List<Object []> gettingTableList () ; 
    
    
   @Query (value =  "SELECT customer_name, email_address FROM customer where id = :customerId", nativeQuery =  true)
   List<Object []>gettingCutomerByIdList (Long customerId) ; 
   
   
   
//The @Modifying annotation signals that the query will make changes to the database, 
//which is necessary for DELETE, UPDATE, and INSERT operations.

   
// Here at Delete method, we are deleting from CustomerModel not from table 
//The reason is we don't specify nativeQuery = true here. and that's why this will be treated as JPQL query for 
//which it requires JAVA Model if we specify table_name i.e. customer and uses nativeQuery = true then it will work 
// but as of now when we don't specify it will be treated as JPQL query & for that it requires Model Name not table name.    
 
// The reason why methods annotated with @Modifying often have a return type of void, int, or Integer is because these methods are not expected to return a domain object123. Instead, they’re expected to change the state of the database and then either return nothing (void) or return the number of affected rows (int or Integer)1   
   @Transactional
   @Modifying
   @Query(value = "DELETE FROM customer WHERE id = :customerId", nativeQuery = true)
   void deleteUsingId(@Param("customerId") Long customerId);
   
   @Transactional
   @Modifying
   @Query (value = "INSERT INTO customer (customer_name, email_address) VALUES (:name, :email)", nativeQuery = true)
   public void savingCustomerData (@Param("name") String customerName, @Param("email") String emailId); 
   
   
  
   
   
   
  
    
    
}
