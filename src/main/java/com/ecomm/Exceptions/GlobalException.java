package com.ecomm.Exceptions;


import org.json.JSONObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(NotFound.class)
    public ResponseEntity<String> UserNotFoundException(NotFound ex) {
    	
    	JSONObject response=new JSONObject();
    	response.put("status", HttpStatus.NOT_FOUND);
    	response.put("status code", 404);
    	response.put("message", ex.getMessage());
        return new ResponseEntity(response.toString(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(handleExceptionCustom.class)
    public ResponseEntity<String> handleExceptionCustom(handleExceptionCustom ex) {
    	
    	JSONObject response=new JSONObject();
    	response.put("status", HttpStatus.BAD_REQUEST);
    	response.put("status code", 404);
    	response.put("message", ex.getMessage());
    	return new ResponseEntity(response.toString(),HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<String> InternalServerException(InternalServerException ex){
    	
    	JSONObject response=new JSONObject();
    	response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
    	response.put("status code", 404);
    	response.put("message", ex.getMessage());
    	return new ResponseEntity(response.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }
    
    @ExceptionHandler(Conflict.class)
    public ResponseEntity<String> Conflic(Conflict ex){
    	
    	JSONObject response=new JSONObject();
    	response.put("status", HttpStatus.CONFLICT);
    	response.put("status code", 409);
    	response.put("message", ex.getMessage());
    	return new ResponseEntity(response.toString(),HttpStatus.CONFLICT);
    	
    }
    
}
