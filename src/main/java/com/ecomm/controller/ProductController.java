package com.ecomm.controller;

import java.sql.SQLException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.Exceptions.*;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.model.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name="Products API")
public class ProductController {
	
	@Autowired
    ProductDAO productdao;
	
	 @GetMapping("/product/{id}")
	  @Operation(summary="get products by Id")
	 public ResponseEntity<?> getProductsbyId(@PathVariable int id){
	    	try {
	    		Product products = productdao.getById(id);
	    		JSONObject r=new JSONObject();
	    		r.put("Status", HttpStatus.OK);
	    		r.put("Status code", 200);
	    		r.put("message", "Success");
	    		r.put("Data", products.toString());
	    		return new ResponseEntity<>(r.toString(),HttpStatus.OK);
	    	}
	    	catch (Exception e){
	    		System.out.println(e.getMessage());
	    		return null;
		}
	    }

	    @GetMapping("/all_products")
	    @Operation(summary="get all products")
	    public ResponseEntity<?> getUsers(){
	    	try {
	    		JSONObject r=new JSONObject();
	    		List<Product> user = productdao.allProducts();
	    		r.put("Status", HttpStatus.OK);
	    		r.put("Status code", 200);
	    		r.put("message", "Success");
	    		r.put("Data", user);
	    		return new ResponseEntity<>(r.toString(),HttpStatus.OK);
	    	}
	        catch(Exception e) {
	        	System.out.println(e.getMessage());
	        	return null;
	        }
	        
	    }
	    @PostMapping("/add_product")
	    @Operation(summary="Add product")
	    public ResponseEntity<?> addUser(@RequestBody Product user) throws SQLException{
	    	try {
	    		productdao.saveProduct(user);
	    		return new ResponseEntity<>("product added",HttpStatus.CREATED);
	    	}
	    	catch(Exception e) {
	    		System.out.println(e.getMessage());
	    		throw new com.ecomm.Exceptions.Conflict(e.getMessage());
	    	}

	    }
	    @DeleteMapping("/product_remove/{id}")
	    @Operation(summary="Delete product by Id")
	    public ResponseEntity<?> deleteUser(@PathVariable int id){
	    	try {
	    		String s=productdao.deleteById(id);
	    		return new ResponseEntity<>(s,HttpStatus.OK);
	    	}
	    	catch (Exception e){
	    		System.out.println(e.getMessage());
	    		throw new NotFound(e.getMessage());
		}
	    }

}
