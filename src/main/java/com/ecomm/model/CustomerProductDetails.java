package com.ecomm.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class CustomerProductDetails {
	@Id
	public int customerId;
	public String customerName;
	public int customerNumber;
	public String contactNumber;
	public String emailAddress;
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		return "{ customerId=" + customerId + ", customerName=" + customerName
				+ ", customerNumber=" + customerNumber + ", contactNumber=" + contactNumber + ", emailAddress="
				+ emailAddress + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
	public CustomerProductDetails(int customerId, String customerName, int customerNumber, String emailAddress,String contactNumber) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerNumber=customerNumber;
		this.emailAddress = emailAddress;
		this.contactNumber = contactNumber;
	}
	public CustomerProductDetails() {
		super();
	}
    
	
    
}
