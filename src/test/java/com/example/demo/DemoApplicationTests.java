package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CustomerService service;

	@MockBean
	CustomerRepository repository;

	public Date parseDate(String str) throws ParseException {
		SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateformat3.parse(str);
		return date;
	}

	@Test
	public void getCustomersTest() throws ParseException {

		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer(1, "Mohammed", "moh@gmail.com", "Gold", 50, "gram", 150, 96188270,
				parseDate("2019-08-16")));
		list.add(new Customer(2, "shaik", "s@gmail.com", "Gold", 50, "gram", 500, 91107053, parseDate("2019-08-15")));

		when(repository.findAll()).thenReturn(list);

		System.out.println("customer count::" + service.getCustomer().size());
		assertEquals(list.size(), service.getCustomer().size());
	}
	
	@Test
	public void saveCustomersTest() throws ParseException{
		Customer customer=new Customer(1, "Mohammed", "moh@gmail.com", "Gold", 50, "gram", 150, 96188270,
				parseDate("2019-08-16"));
		service.create(customer);
		verify(repository,times(1)).save(customer);

		
	}
	
	@Test
	public void deleteCustomersTest() throws ParseException{
		Customer customer=new Customer(1, "Mohammed", "moh@gmail.com", "Gold", 50, "gram", 150, 96188270,
				parseDate("2019-08-16"));
		service.deleteById(1);
		verify(repository,times(1)).deleteById(1);

		
	}

}
