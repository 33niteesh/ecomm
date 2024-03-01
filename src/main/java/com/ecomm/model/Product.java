package com.ecomm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import com.ecomm.model.*;
@Entity
public class Product {
	@Id
	public int productId;
	public String productName;
	public String productDescription;
	public String availability;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	public Product(int productId,String productName, String productDescription, String availability) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.availability = availability;
	}
	
	
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "{"+"productId"+ productId+ " productName:"+productName+" productDescription:"+ productDescription+" availability:"+ availability+"}";
	}
    
    
}
