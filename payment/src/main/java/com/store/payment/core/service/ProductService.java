/**
 * 
 */
package com.store.payment.core.service;

import java.util.List;
import java.util.Optional;

import com.store.payment.core.model.Product;

/**
 * Definition of services
 * @author Natalian Estrada
 *
 */
public interface ProductService {
	public List<Product> findAllProducts();

	public Optional<Product> findProductById(Long id);

	public Product saveProduct(Product product);

	public String deleteProduct(Long id);

	public String updateProduct(Product product);

}
