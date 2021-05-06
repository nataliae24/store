/**
 * 
 */
package com.store.payment.core.service;

import java.util.List;
import java.util.Optional;

import com.store.payment.core.model.Customer;

/**
 * Definition of services
 * @author Natalian Estrada
 *
 */
public interface CustomerService {
	public List<Customer> findAllCustomers();

	public Optional<Customer> findCustomerById(Long id);

	public Customer saveCustomer(Customer customerNew);

	public String deleteCustomer(Long id);

	public String updateCustomer(Customer customerNew);

}
