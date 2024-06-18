package com.example.newspring.Newspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "shipping_table")


public class shippingTable {
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idLong ; 
	
	
	@Column 
	private String shippingAddressString ; 

	@Column 
	private String productString ; 
	
	
	
	
	

}
