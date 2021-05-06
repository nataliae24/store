/**
 * 
 */
package com.store.payment.core.service.impl;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.payment.core.model.Order;
import com.store.payment.core.model.StatusEnum;
import com.store.payment.core.repository.OrderRepository;
import com.store.payment.core.service.OrderService;

/**
 * Definition of implements services
 * @author Natalian Estrada
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired		
	OrderRepository orderRepository;
	
	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> findOrderById(Long id) {
		Optional<Order> order = orderRepository.findById(id);			
		return order;
	}

	public Order saveOrder(Order order) {
		if (order != null) {
			return orderRepository.save(order);
		}
		return new Order();
	}

	public String deleteOrder(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {	
			LocalDateTime dateNow = LocalDateTime.now();
		   	LocalDateTime dateThen = LocalDateTime.parse(order.get().getOrderDate().toString());
	        long hours = dateNow.until(dateThen, ChronoUnit.HOURS);
	        System.out.println((hours % 24) + " hours.");
	        if(hours < 12 ) {
	        	orderRepository.deleteById(id);				
				return "Orden eliminada correctamente.";	
	        }else {
	        	//>12 horas facturar 10% valor pedido y cancelarlo
	        	Long valueOrder = order.get().getTotalBill();
	        	double newValueOrder = 0.10 * valueOrder;
	        	order.get().setTotalBill((long) newValueOrder);
	        	order.get().setStatusOrder(StatusEnum.CANCELLED);
	        }
					
		}			
		return "Error! La orden no existe";
	}

	//TODO Datos llenar
	public String updateOrder(Order order) {
		Long num = order.getId();			
		if (orderRepository.findById(num).isPresent()) {
			Order orderUpdate = new Order();	
				LocalDateTime dateNow = LocalDateTime.now();
			   	LocalDateTime dateThen = LocalDateTime.parse(orderUpdate.getOrderDate().toString());
		        long hours = dateNow.until(dateThen, ChronoUnit.HOURS);
		        System.out.println((hours % 24) + " hours.");
		        if(hours < 5 ) {
		        	orderUpdate.setId(1L);			
					orderRepository.save(orderUpdate);				
					return "Orden actualizada";		
		        }else {
		        	return "Ha transcurrido mucho tiempo para actualizar la orden";
		        }
			
				
			}			
		return "Error al actualizar la orden";
	}

}
