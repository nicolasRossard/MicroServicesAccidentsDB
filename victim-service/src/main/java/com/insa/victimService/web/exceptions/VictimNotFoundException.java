package com.insa.victimService.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* Exception if Victim Id not found */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class VictimNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VictimNotFoundException(String s) {
		super(s);
	}
}
