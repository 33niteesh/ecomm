package com.ecomm.DAO;

import java.util.List;

import com.ecomm.model.CustomerProduct;

public interface CustomerProductDAO {

	CustomerProduct saveCustomerproduct1(CustomerProduct data);

	List<CustomerProduct> getById(int id);

	String deleteById(int id,int pid);

    List<CustomerProduct> alldata();
}
