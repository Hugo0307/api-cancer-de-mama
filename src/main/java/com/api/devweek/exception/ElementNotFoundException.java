package com.api.devweek.exception;

public class ElementNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ElementNotFoundException(Long id) {
		super("Não foi possível encontrar o registro " + id);	
	}
	
}
