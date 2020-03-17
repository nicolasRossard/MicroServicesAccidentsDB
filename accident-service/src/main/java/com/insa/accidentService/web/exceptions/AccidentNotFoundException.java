package com.insa.accidentService.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* Exception if Accident Id not found */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AccidentNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccidentNotFoundException(String s) {
		super(s);
	}
}
