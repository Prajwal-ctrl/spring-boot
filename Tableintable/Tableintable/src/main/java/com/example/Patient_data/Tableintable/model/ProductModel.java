package com.example.Patient_data.Tableintable.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "products")

public class ProductModel {
	
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long product_id ; 
	
	
	@Column (name = "product_name")
	private String productName;
	
	
	@Column (name = "product_price")
	private Integer productPrice;
	
	
	public  ProductModel() {
		
	}
	
	public  ProductModel (String productName, Integer productPrice) {
		this.productName = productName ; 
		this.productPrice = productPrice ; 
	}
	


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	} 
	
	
	
	
	

}
