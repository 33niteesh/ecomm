package com.ecomm.DAO;

import java.util.List;

import com.ecomm.model.*;

public interface ProductDAO {
	Product saveProduct(Product user);

	Product getById(int id);

	String deleteById(int id);

    List<Product> allProducts();
}
