package com.example.Patient_data.Tableintable.repository;

import java.util.List;

import org.hibernate.type.TrueFalseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Patient_data.Tableintable.model.CustomerModel;

import jakarta.transaction.Transactional;
import jakarta.validation.spi.ValidationProvider;



public interface CustomerRepository extends JpaRepository<CustomerModel, Integer> {

	
//	@Query(value = "SELECT * FROM gettable()", nativeQuery = true)
//  List<Object[]> gettable();
	
	
	//getall
	@Query (value =  "SELECT *FROM get_customer_product_data()", nativeQuery = true)
	List<Object[]> get_customer_product_data(); 
	
	
	
	//getcustomer according to id & relatively their products 
	
	@Query (value =  "select * from get_details_by_id (:customer_id)", nativeQuery = true)
	List <Object[]> get_details_by_id (Long customer_id) ; 
	
	
	//make a new customer (don't forget to use sequence generator to db side using java)
	
	
	
	//post a new customer 
	
	
	
	//post a new product 
	@Query (value =  "select * from save_data (:customer_name, :customer_phone,:customer_email)", nativeQuery = true)
	public CustomerModel save_data(String customer_name, String customer_phone, String customer_email)  ; 
	
	
	//update customers_product_data: 
//	
	@Query(value = "select * from update_customers_products (:product_name, :prodcut_price,) ", nativeQuery = true)
	public CustomerModel update_customers_products(String product_name, String product_price) ;
	
	//delete customer & product.
	@Query (value = "SELECT * FROM delete_customer_by_id (:customer_id)", nativeQuery = true )
	void delete_customer_by_id (Long customer_id) ; 

	

  	
}
