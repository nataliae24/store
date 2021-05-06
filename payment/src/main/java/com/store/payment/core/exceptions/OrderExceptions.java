package com.store.payment.core.exceptions;

public class OrderExceptions extends Exception  {


	/**
	 * Excepción order not found
	 * @param id
	 */
	public OrderExceptions(String id) {
		 super(String.format("la orden no existe: ", id));
	}

	
}
