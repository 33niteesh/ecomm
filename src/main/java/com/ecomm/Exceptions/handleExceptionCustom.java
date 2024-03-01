package com.ecomm.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class handleExceptionCustom extends RuntimeException {
	String message;
    public handleExceptionCustom(String message) {
        super();
        this.message=message;
    }
    public String getMessage() {
		return message;
	}
}

