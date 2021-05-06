/**
 * 
 */
package com.store.payment.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.payment.core.exceptions.ProductExceptions;
import com.store.payment.core.model.Product;
import com.store.payment.core.service.ProductService;


@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> productsList() {
		List<Product> dataList =  productService.findAllProducts();
		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable Long id) throws ProductExceptions {
		Optional<Product> product = productService.findProductById(id);

		if (product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
		try {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		try {
			Product savedProduct = productService.saveProduct(product);

			return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product Product, @PathVariable Long id) {

		Optional<Product> productOptional = productService.findProductById(id);

		if (productOptional.isPresent()) {
			Product productData = productOptional.get();
			productData.setId(id);
			productData.setPrice("85000");

			return new ResponseEntity<>(productService.saveProduct(productData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
