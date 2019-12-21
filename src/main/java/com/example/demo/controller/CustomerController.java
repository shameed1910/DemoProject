package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

//@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
//To insert the customer data into database
	@PostMapping(value="/insert")
	public void createCustomer(@RequestBody Customer customer){
		customerService.create(customer);
	}

	//To get the list of customers
	@GetMapping(produces = "application/json",value="/getUsers")
	public List<Customer> getCustomer(){
		return customerService.getCustomer();
	}
	//update customer
	@PutMapping(value="/updateUser")
	public Customer updateCustomer(@RequestBody Customer customer){
		return customerService.update(customer, customer.getId());
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id){
		
		 customerService.deleteById(id);
	}
	@Autowired
	ReportService reportService;
	
	@GetMapping("/downloadReport/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException{
		return reportService.exportReport(format);
	}
}
