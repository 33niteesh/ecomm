package com.ecomm.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class Conflict extends RuntimeException{
	String message;
    public Conflict(String message) {
        super();
        this.message=message;
    }
    public String getMessage() {
		return message;
	}
}
