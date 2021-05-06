/**
 * 
 */
package com.store.payment.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.payment.core.model.Customer;
import com.store.payment.core.repository.CustomerRepository;
import com.store.payment.core.service.CustomerService;

/**
 * Definition of implements services
 * @author Natalian Estrada
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired		
	CustomerRepository customerRepository;
	
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	public Optional<Customer> findCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);			
		return customer;
	}

	public Customer saveCustomer(Customer customer) {
		if (customer != null) {
			return customerRepository.save(customer);
		}
		return new Customer();
	}

	public String deleteCustomer(Long id) {
		if (customerRepository.findById(id).isPresent()) {				
			customerRepository.deleteById(id);				
			return "Cliente eliminado correctamente.";			
		}			
		return "Error! El cliente no existe";
	}

	//TODO Datos llenar
	public String updateCustomer(Customer customer) {
		Long num = customer.getId();			
		if (customerRepository.findById(num).isPresent()) {				
			Customer customerUpdate = new Customer();				
			customerUpdate.setId(1L);				
			customerUpdate.setFirstName("Maria");				
			customerUpdate.setFirstName("Yepes");	
			customerRepository.save(customerUpdate);				
			return "Cliente actualizado";			
			}			
		return "Error al modificar el cliente";
	}

}
