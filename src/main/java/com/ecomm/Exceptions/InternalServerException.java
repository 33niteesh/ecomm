package com.ecomm.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InternalServerException extends RuntimeException {
	String message;
    public InternalServerException(String message) {
        super();
        this.message=message;
    }
    public String getMessage() {
		return message;
	}
}
