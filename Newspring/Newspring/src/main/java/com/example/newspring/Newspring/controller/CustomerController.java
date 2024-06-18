package com.example.newspring.Newspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.newspring.Newspring.Repository.CustomerRepository;
import com.example.newspring.Newspring.model.CustomerModel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@RestController
@RequestMapping ("/api/v1")

public class CustomerController {
	
	@Autowired
	private CustomerRepository customerrepository ; 
	
//	
//	@GetMapping ("/customer")
//	public List<Object[]> getCustomer() {
//        return customerrepository.gettable();
//    }
//	
	
//	@GetMapping ("/customer/{id}")
//	public ResponseEntity<Object> getCustomerByIdCustomer (@PathVariable Long id) {
//		 Object customer =  customerrepository.customer_by_id(id) ; 
//		 return ResponseEntity.ok(customer) ; 
//	}
//	 
//	
//	@PostMapping("/customer")
//	public CustomerModel postCustomer(@RequestBody CustomerModel customerModel) {
//		CustomerModel customermodel = new CustomerModel() ; 
//		customermodel = customerrepository.save_customer(customerModel.getCustomerName(), customerModel.getEmailId());
//	 
//	 return customermodel ; 
//	}
	
//	@DeleteMapping("/customer/{id}")
//	public ResponseEntity<Void> deleteCustomer (@PathVariable Long id) {
//		
//		try {
//            customerrepository.delete_customer(id);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build()  ; 
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  
//        }
//	}
//	

	
// Custom Query Implementation.  
	@GetMapping ("/customer")
	public List <Object[]> gettingTable (){
		return customerrepository.gettingTableList() ; 
	}
	
	
	
	@GetMapping ("/customer/{id}")
	public List <Object []> gettingCustomer (@PathVariable Long id){
		return customerrepository.gettingCutomerByIdList(id) ; 
	}
	
	
	@DeleteMapping ("/customer/{id}")
	public ResponseEntity<Void> deleteCustomerById (@PathVariable Long id) {
		try {
		customerrepository.deleteUsingId (id);  
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build () ; 
		
	}catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  

	}
		
}
	
@PostMapping ("/customer")
public CustomerModel createCustomer (@RequestBody CustomerModel customermodel) { 
	  customerrepository.savingCustomerData(customermodel.getCustomerName(), customermodel.getEmailId());
	  return customermodel ; 
}
	
	































































//@PostMapping("/customer")
//public CustomerModel postCustomer(@RequestBody CustomerModel customerModel) {
//	CustomerModel customermodel = new CustomerModel() ; 
//	customermodel = customerrepository.save_customer(customerModel.getCustomerName(), customerModel.getEmailId());
// 
// return customermodel ; 
//}


	// TODO Auto-generated method stub
	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PutMapping("/customer/{id}")
//	public List<Object[]> UpdateCustomer (@PathVariable Long id, @RequestBody CustomerModel customerModel ) {
//		
//		Optional<CustomerModel> customerModel1 = CustomerRepository.findById(id)
//		
//		return null;
//	
//	}
//	
//	
	

