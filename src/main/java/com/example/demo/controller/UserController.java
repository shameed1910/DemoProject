package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/register")
	public void createCustomer(@RequestBody User user) {
		userService.create(user);
	}

}
