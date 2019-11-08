package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Customer;

public interface CustomerService {
	
	public void create(Customer customer);
	public List<Customer> getCustomer();
	public Optional<Customer> findCustomerById(Integer id);
	public Customer update(Customer customer,Integer id);
	public void deleteById(Integer id);

}
