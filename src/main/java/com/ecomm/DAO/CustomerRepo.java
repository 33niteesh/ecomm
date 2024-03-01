package com.ecomm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecomm.model.CustomerProductDetails;
import com.ecomm.model.Product;

@Repository
public class CustomerRepo implements CustomerDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CustomerProductDetails saveCustomer(CustomerProductDetails prd) {
        jdbcTemplate.update(Constants.INSERT_USER_QUERY,prd.getCustomerId(),prd.getCustomerName(),prd.getCustomerNumber(),prd.getEmailAddress(),prd.getContactNumber());
        return prd;
    }


    @Override
    public List<CustomerProductDetails> getById(int id) {
        return jdbcTemplate.query(Constants.GET_USER_BY_ID_QUERY1, (rs, rowNum) -> {
        	return new CustomerProductDetails(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getInt("customer_number"),rs.getString("email_address"),rs.getString("contact_number"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        Integer i=jdbcTemplate.update(Constants.DELETE_USER_BY_ID1, id);
        if(i!=1) {
        	return "Customer notfound : ";
        }
        return "Customer got deleted with id :" + id;
    }

    @Override
    public List<CustomerProductDetails> allCustomers() {
    	return jdbcTemplate.query(Constants.GET_USERS_QUERY1, (rs, rowNum) -> {
        	return new CustomerProductDetails(rs.getInt("customer_id"), rs.getString("customer_name"), rs.getInt("customer_number"),rs.getString("email_address"),rs.getString("contact_number"));
        });
    }
}
