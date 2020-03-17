package com.insa.victimService.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VictimUpdateException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VictimUpdateException(String s) {
		super(s);
	}
}
