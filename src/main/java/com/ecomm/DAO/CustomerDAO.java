package com.ecomm.DAO;

import java.util.List;

import com.ecomm.model.*;

public interface CustomerDAO {
	CustomerProductDetails saveCustomer(CustomerProductDetails user);

	List<CustomerProductDetails> getById(int id);

	String deleteById(int id);

    List<CustomerProductDetails> allCustomers();
}
