package com.ecomm.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.json.JSONParser;
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

import com.ecomm.DAO.CustomerDAO;
import com.ecomm.DAO.CustomerProductDAO;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.Exceptions.NotFound;
import com.ecomm.model.CustomerProduct;
import com.ecomm.model.CustomerProductDetails;
import com.ecomm.model.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v3")
@Tag(name="Data API")
public class DataController {
	@Autowired
    CustomerProductDAO productdao;
	@Autowired
    ProductDAO prddao;
	@GetMapping("/data/{id}")
	  @Operation(summary="get data by Id")
	 public ResponseEntity<?> getProductsbyId(@PathVariable int id){
	    	try {
	    		List<CustomerProduct> products = productdao.getById(id);
	    		List<Product> prd = new ArrayList<>();
	    		for(int i=0;i<products.size();i++) {
	    			Product p=prddao.getById(products.get(i).getProductId());
	    			prd.add(p);
	    		}
	    		JSONObject r=new JSONObject();
	    		r.put("Status", HttpStatus.OK);
	    		r.put("Status code", 200);
	    		r.put("message", "Success");
	    		r.put("CustomerId details", products);
	    		r.put("Data",prd);
	    		return new ResponseEntity<>(r.toString(),HttpStatus.OK);
	    	}
	    	catch (Exception e){
	    		System.out.println(e.getMessage());
	    		return null;
		}
	    }

	    @GetMapping("/all_data")
	    @Operation(summary="get all data")
	    public ResponseEntity<?> getUsers(){
	    	try {
	    		JSONObject r=new JSONObject();
	    		List<CustomerProduct> user = productdao.alldata();
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
	    @PostMapping("/add_customer_product")
	    @Operation(summary="add_customer_product")
	    public ResponseEntity<?> addUser(@RequestBody CustomerProduct user) throws SQLException{
	    	try {
	    		Product p=prddao.getById(user.getProductId());
	    		System.out.print(p.getAvailability());
	    		if(p.getAvailability().toString().equals("yes")) {
	    			productdao.saveCustomerproduct1(user);
	    			return new ResponseEntity<>("customer product added",HttpStatus.CREATED);
	    		}else {
	    			return new ResponseEntity<>("product not available",HttpStatus.CONFLICT);
	    		}
	    	}
	    	catch(Exception e) {
	    		System.out.println(e.getMessage());
	    		throw new com.ecomm.Exceptions.NotFound(e.getMessage());
	    	}

	    }
	    @DeleteMapping("/customer_product_remove/{id}")
	    @Operation(summary="Delete product from by Id")
	    public ResponseEntity<?> deleteUser(@PathVariable int id,@RequestBody CustomerProduct pid){
	    	try {
	    		String s=productdao.deleteById(id,pid.getProductId());
	    		return new ResponseEntity<>(s,HttpStatus.OK);
	    	}
	    	catch (Exception e){
	    		System.out.println(e.getMessage());
	    		throw new NotFound(e.getMessage());
		}
	    }
}
