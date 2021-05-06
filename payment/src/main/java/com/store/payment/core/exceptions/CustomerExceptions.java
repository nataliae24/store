package com.store.payment.core.exceptions;

public class CustomerExceptions extends Exception  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Excepción customer not found
	 * @param id
	 */
	public CustomerExceptions(String id) {
		 super(String.format("El cliente no existe: ", id));
	}

}
