package com.ecomm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecomm.model.CustomerProduct;
import com.ecomm.model.Product;
import com.ecomm.DAO.*;
@Repository
public  class CustomerProductRepo implements CustomerProductDAO{
	 
	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public CustomerProduct saveCustomerproduct1(CustomerProduct prd) {
	        jdbcTemplate.update(Constants.INSERT_USER_QUERY,prd.getProductId(),prd.getCustomerId());
	        return prd;
	    }


	    @Override
	    public List<CustomerProduct> getById(int id) {
	        return jdbcTemplate.query(Constants.GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
	        	return new CustomerProduct(rs.getInt("customer_id"), rs.getInt("product_id"));
	        },id);
	    }

	    @Override
	    public String deleteById(int id,int pid) {
	        Integer i=jdbcTemplate.update(Constants.DELETE_USER_BY_ID, id,pid);
	        if(i!=1) {
	        	return "product notfound : ";
	        }
	        return "product got deleted with id :" + id;
	    }

	    @Override
	    public List<CustomerProduct> alldata() {
	        return jdbcTemplate.query(Constants.GET_USERS_QUERY, (rs, rowNum) -> {
	            return new CustomerProduct(rs.getInt("customer_id"),rs.getInt("product_id"));
	        });
	    }


		
}
