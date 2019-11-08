/*package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CustomerService service;
	
	@Mock
	CustomerRepository repository;
	
	public Date parseDate(String str)throws ParseException{
	SimpleDateFormat dateformat3 = new SimpleDateFormat("yyyy-MM-dd");
	Date date = dateformat3.parse(str);
	return date;
	}

	
	@Test
	public void getCustomersTest() throws ParseException{
		
		List<Customer>  list=new ArrayList<Customer>();
		list.add(new Customer(1, "Mohammed", "moh@gmail.com", "Gold", 50, "gram",
		15000, parseDate("2019-08-16")));
		list.add(new Customer(2, "shaik", "s@gmail.com", "Gold", 50, "gram",
				500, 9618827027,parseDate("2019-08-15")));
		
		when(repository.findAll()).thenReturn(list);

assertEquals(2, service.getCustomer().size());
				
	}
}
*/