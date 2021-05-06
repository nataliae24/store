package com.store.payment.core.exceptions;

public class ProductExceptions extends Exception {

	/**
	 * Excepción product not found
	 * @param id
	 */
	public ProductExceptions(String id) {
		 super(String.format("el producto no existe: ", id));
	}

}
