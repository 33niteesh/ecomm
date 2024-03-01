package com.ecomm.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
	String message;
    public NotFound(String message) {
        super();
        this.message=message;
    }
    public String getMessage() {
		return message;
	}
    
}
