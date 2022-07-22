package com.lq.bank.data;

import org.springframework.data.repository.CrudRepository;

import com.lq.bank.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
