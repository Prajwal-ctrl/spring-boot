package com.example.Patient_data.Tableintable.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name = "customers")

public class CustomerModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.UUID, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequnece", allocationSize = 1)
	private Long customer_id;
	
	
	@Column (name =  "customer_name")
	private String customerName ; 
	
	@Column (name = "customer_email")
	private String customerEmail ; 
	
	@Column (name = "customer_phone")
	private String customerPhone ; 
	
	

	
	public CustomerModel() {
		
	}
	
	public CustomerModel (String customerName, String customerEmail,String customerPhone) {		
		
		this.customerName = customerName ; 
		this.customerPhone= customerPhone  ; 
		this.customerEmail  = customerEmail ;
		
		
	}

	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getcustomerEmail() {
		return customerEmail;
	}


	public void setcustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public List<ProductModel> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
