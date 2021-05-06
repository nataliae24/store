/**
 * 
 */
package com.store.payment.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.payment.core.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
