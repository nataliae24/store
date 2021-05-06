/**
 * 
 */
package com.store.payment.core.controller;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.OffsetTimeType;
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

import com.store.payment.core.exceptions.OrderExceptions;
import com.store.payment.core.model.Order;
import com.store.payment.core.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> orderList() {
		List<Order> customerList =  orderService.findAllOrders();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@GetMapping("/order/{id}")
	public ResponseEntity<Order> findOrder(@PathVariable Long id) throws OrderExceptions {
		Optional<Order> order = orderService.findOrderById(id);

		if (order.isPresent()) {
			return new ResponseEntity<>(order.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long id) {
		
		try {
			orderService.deleteOrder(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		
		try {
			Order savedOrder = orderService.saveOrder(order);
			savedOrder.setOrderDate(LocalDateTime.now());
			return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/order/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id) {

		Optional<Order> orderOptional = orderService.findOrderById(id);

		if (orderOptional.isPresent()) {
			Order orderData = orderOptional.get();

			return new ResponseEntity<>(orderService.saveOrder(orderData), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
