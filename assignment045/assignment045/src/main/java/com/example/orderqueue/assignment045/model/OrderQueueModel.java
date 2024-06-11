package com.example.orderqueue.assignment045.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;



@Entity 
@Table (name = "orderqueue")
//@NamedStoredProcedureQuery (name = "order.GetData", procedureName = "getorderversion2(:orderid)", parameters = {
//		@StoredProcedureParameter (mode = ParameterMode.IN, name =  "orderid", type = UUID.class),
//		@StoredProcedureParameter (mode = ParameterMode.OUT, name =  "orderid", type = UUID.class),
//		@StoredProcedureParameter (mode = ParameterMode.OUT, name =  "ordercategory", type = UUID.class),
//		@StoredProcedureParameter (mode = ParameterMode.OUT, name =  "orderstatus", type = UUID.class),
//		@StoredProcedureParameter (mode = ParameterMode.OUT, name =  "isactive", type = UUID.class),
//		@StoredProcedureParameter (mode = ParameterMode.OUT, name =  "orderprovider", type = UUID.class),
//})


public class OrderQueueModel {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.UUID)
	
	private UUID orderid ; 
	private OffsetDateTime orderdate  ; 
	private String ordercategory  ; 
	private String orderstatus  ; 
	private boolean isactive ; 
	private String orderprovider  ;
	private Long acessionnumber ;
	
	
	
	public OrderQueueModel() {
	  this.orderid = UUID.randomUUID() ; 
 	}
	
	public UUID getOrderid() {
		return orderid;
	}
	public void setOrderid(UUID orderid) {
		this.orderid = UUID.randomUUID() ;
	}
	public OffsetDateTime getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(OffsetDateTime orderdate) {
		this.orderdate = orderdate;
	}
	public String getOrdercategory() {
		return ordercategory;
	}
	public void setOrdercategory(String ordercategory) {
		this.ordercategory = ordercategory;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
//Provider : 
	public String getOrderprovider() {
		return orderprovider;
	}
	public void setOrderprovider(String orderprovider) {
		this.orderprovider = orderprovider;
	}

	
//acessionnumber
	public Long getAcessionnumber() {
		return acessionnumber;
	}

	public void setAcessionnumber(Long acessionnumber) {
		this.acessionnumber = acessionnumber;
	} 
	

}
