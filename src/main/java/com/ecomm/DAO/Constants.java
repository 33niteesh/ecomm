package com.ecomm.DAO;

public class Constants {
	public static final String INSERT_USER_QUERY = "INSERT INTO customer_product(product_id,customer_id) values(?,?)";
    public static final String GET_USER_BY_ID_QUERY = "SELECT * FROM customer_product WHERE customer_id=?";
    public static final String DELETE_USER_BY_ID = "DELETE FROM customer_product WHERE customer_id=? and product_id=?";
    public static final String GET_USERS_QUERY = "SELECT * FROM customer_product";
    public static final String INSERT_USER_QUERY1 = "INSERT INTO customer(customer_id,customer_name,customer_number,email_address,contact_number) values(?,?,?,?,?)";
    public static final String GET_USER_BY_ID_QUERY1 = "SELECT * FROM customer WHERE customer_id=?";
    public static final String DELETE_USER_BY_ID1 = "DELETE FROM customer WHERE customer_id=?";
    public static final String GET_USERS_QUERY1 = "SELECT * FROM customer";
    public static final String INSERT_USER_QUERY2 = "INSERT INTO product(product_id,product_name,product_description,availability) values(?,?,?,?)";
    public static final String GET_USER_BY_ID_QUERY2 = "SELECT * FROM product WHERE product_id=?";
    public static final String DELETE_USER_BY_ID2 = "DELETE FROM product WHERE product_id=?";
    public static final String GET_USERS_QUERY2 = "SELECT * FROM product";
    public static final String GET_USER_PROD="select * from product p, customer_product cp where p.product_id=cp.product_id and cp.customer_id=?";
}
