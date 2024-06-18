package com.example.newspring.Newspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table (name = "customer")


public class CustomerModel {
	@Id
	@GeneratedValue (strategy = GenerationType.UUID, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequnece", allocationSize = 1)


	private long id ; 
	
	@Column (name =  "customer_name")
	private String customerName ; 
	
	@Column (name = "email_address")
	private String emailId ; 
	
	

	public CustomerModel() {
		
	}
	
	public CustomerModel (String customerName, String emailId) {		
		
		this.customerName = customerName ; 
		this.emailId  = emailId ;
		
	}
	
	
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
