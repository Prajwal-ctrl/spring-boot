package com.example.Patient_data.Tableintable.controller;

import java.util.List;

import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Patient_data.Tableintable.model.CustomerModel;
import com.example.Patient_data.Tableintable.model.ProductModel;
import com.example.Patient_data.Tableintable.repository.CustomerRepository;
import com.example.Patient_data.Tableintable.repository.ProductRepository;


@RestController
@RequestMapping ("/api/v1")

public class CustomerController {

	
	@Autowired CustomerRepository customerrepository ; 
	@Autowired ProductRepository productrepository ; 

	
	@GetMapping ("/customer")
	public List<Object []> getcustomerdata() {
		return customerrepository.get_customer_product_data() ; 
	}
	
	
	@GetMapping("/customer/{customer_id}")
	public List<Object[]> getById (@PathVariable Long customer_id) {
		return customerrepository.get_details_by_id(customer_id) ; 
		 
	}
	
	
	@DeleteMapping("customer/{customer_id}")
	public ResponseEntity<Void> deleteCustomerDataEntity (@PathVariable Long customer_id) {
		
		try {
          customerrepository.delete_customer_by_id(customer_id);
          return ResponseEntity.status(HttpStatus.NO_CONTENT).build()  ; 
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
      }
	}
	
	
	@PostMapping("/add")
	public CustomerModel saveCustomerDataCustomerModels (@RequestBody CustomerModel customermodel){
		
	    return customerrepository.save_data(customermodel.getCustomerName(), customermodel.getcustomerEmail(), customermodel.getCustomerPhone());

	}
	
//	 @PostMapping("/saveCustomerData")
//	    public ResponseEntity<CustomerModel> saveCustomerData(@RequestBody CustomerModel customerModel) {
//	        customerrepository.update_customers_products(customerModel.getCustomerName(), customerModel.getCustomerPhone());
//	        // Save products
//	        List<ProductModel> products = customerModel.getProducts();
//	        for (ProductModel product : products) {
//	            customerrepository.update_customers_products(product.getProductName(), product.getProductPrice());
//	        }
//	        return ResponseEntity.ok(customerModel);
//	    }
//	
	
	
	

	
	
	
	
	
	
	
	
	
//	@PutMapping ("/customer/{customer_id}")
//	public ResponseEntity<CustomerModel> updateCustomerProducts (@RequestBody String productName, String productPrice){
//		
//		CustomerModel customermodel = customerrepository.findById(id)
//		.orElseThrow(() -> new ResourceNotFoundException("customer not exist with id :" + id));
//
//customermodel.setProductName(.getProductName());
//
//CustomerModel updateCustomerProducts = customerrepository.update_customers_products(customermodel);
//return ResponseEntity.ok(updateCustomerProducts);		
//		
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()  ; 
//	}
	
	

	
//	@GetMapping("/save")
//	public List<Object[]> saveCutomerDetailsList (@PathVariable CustomerModel customerModel){
//		
//		return customerrepository.save_data(null, null)
//		
//	}
	
}













