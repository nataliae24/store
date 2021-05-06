/**
 * 
 */
package com.store.payment.core.service;

import java.util.List;
import java.util.Optional;

import com.store.payment.core.model.Order;

/**
 * Definition of services
 * @author Natalian Estrada
 *
 */
public interface OrderService {
	public List<Order> findAllOrders();

	public Optional<Order> findOrderById(Long id);

	public Order saveOrder(Order order);

	public String deleteOrder(Long id);

	public String updateOrder(Order order);

}
