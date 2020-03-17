package com.insa.victimService.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VictimAddException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VictimAddException(String s) {
		super(s);
	}

}
