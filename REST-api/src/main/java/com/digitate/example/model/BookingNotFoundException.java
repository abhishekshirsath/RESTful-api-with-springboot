package com.digitate.example.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookingNotFoundException extends RuntimeException {

	public BookingNotFoundException(String msg) {
		super(msg);
	}
	
}
