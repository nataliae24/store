/**
 * 
 */
package com.store.payment.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.payment.core.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	void save(Optional<Order> order);

}
