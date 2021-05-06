/**
 * 
 */
package com.store.payment.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.payment.core.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
