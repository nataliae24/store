/**
 * 
 */
package com.store.payment.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.payment.core.model.Product;
import com.store.payment.core.repository.ProductRepository;
import com.store.payment.core.service.ProductService;

/**
 * Definition of implements services
 * @author Natalian Estrada
 *
 */
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired		
	ProductRepository productRepository;
	
	public List<Product> findAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> findProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);			
		return product;
	}

	public Product saveProduct(Product product) {
		if (product != null) {
			return productRepository.save(product);
		}
		return new Product();
	}

	public String deleteProduct(Long id) {
		if (productRepository.findById(id).isPresent()) {				
			productRepository.deleteById(id);				
			return "Producto eliminado correctamente.";			
		}			
		return "Error! El producto no existe";
	}

	//TODO Datos llenar
	public String updateProduct(Product product) {
		 Long num = product.getId();			
		if (productRepository.findById(num).isPresent()) {				
			Product productUpdate = new Product();				
			productUpdate.setId(1L);				
			productRepository.save(productUpdate);				
			return "Producto actualizado";			
			}			
		return "Error al actualizar el producto";
	}

}
