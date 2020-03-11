package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;

	@Override
	public void create(Customer customer) {
		repository.save(customer);
	}

	@Override
	public List<Customer> getCustomer() {
		
		List<Customer> customers=repository.findAll();
		customers.forEach(customer->System.out.println(customer.getName()));

		return customers;
	}

	@Override
	public Optional<Customer> findCustomerById(Integer id) {

		return repository.findById(id);
	}

	@Override
	public Customer update(Customer customer, Integer id) {

		return repository.save(customer);
	}

	@Override
	public void deleteById(Integer id) {

		repository.deleteById(id);
	}

}
