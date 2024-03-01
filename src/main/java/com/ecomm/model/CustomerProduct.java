package com.ecomm.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_product")
public class CustomerProduct {
	@Override
	public String toString() {
		return "{customerId:" + customerId + ", productId:" + productId + "}";
	}
	@Id
	@Column(name="customer_id")
	public int customerId;
	@Column(name="product_id")
	public int productId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public CustomerProduct(int customerId, int productId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
	}
	
	
}
