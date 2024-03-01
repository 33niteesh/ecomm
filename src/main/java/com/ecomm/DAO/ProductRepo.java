package com.ecomm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecomm.model.*;

@Repository
public class ProductRepo implements ProductDAO{

    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product saveProduct(Product prd) {
        jdbcTemplate.update(Constants.INSERT_USER_QUERY2,prd.getProductId(),prd.getProductName(),prd.getProductDescription(),prd.getAvailability());
        return prd;
    }


    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject(Constants.GET_USER_BY_ID_QUERY2, (rs, rowNum) -> {
        	return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getString("product_description"),rs.getString("availability"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        Integer i=jdbcTemplate.update(Constants.DELETE_USER_BY_ID2, id);
        if(i!=1) {
        	return "product notfound : ";
        }
        return "product got deleted with id :" + id;
    }

    @Override
    public List<Product> allProducts() {
        return jdbcTemplate.query(Constants.GET_USERS_QUERY2, (rs, rowNum) -> {
            return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getString("product_description"),rs.getString("availability"));
        });
    }
}
