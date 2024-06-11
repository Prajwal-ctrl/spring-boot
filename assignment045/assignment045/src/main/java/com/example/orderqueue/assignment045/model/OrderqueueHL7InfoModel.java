package com.example.orderqueue.assignment045.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderqueuehl7info")

public class OrderqueueHL7InfoModel {
	
@Id
private Long transactionid  ;  
private OffsetDateTime	createdon  ;
private String patientname  ; 
private String	insurance ; 
private String	practicename ;  
private String	orderprovider  ;



public Long getTransactionid() {
	return transactionid;
}
public void setTransactionid(Long transactionid) {
	this.transactionid = transactionid;
}
public OffsetDateTime getCreatedon() {
	return createdon;
}
public void setCreatedon(OffsetDateTime createdon) {
	this.createdon = createdon;
}
public String getPatientname() {
	return patientname;
}
public void setPatientname(String patientname) {
	this.patientname = patientname;
}
public String getInsurance() {
	return insurance;
}
public void setInsurance(String insurance) {
	this.insurance = insurance;
}
public String getPracticename() {
	return practicename;
}
public void setPracticename(String practicename) {
	this.practicename = practicename;
}
public String getOrderprovider() {
	return orderprovider;
}
public void setOrderprovider(String orderprovider) {
	this.orderprovider = orderprovider;
}


}
