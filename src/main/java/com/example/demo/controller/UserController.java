package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/register")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping(value = "/insert")
	public void createCustomer(@RequestBody User user) {
		userService.create(user);
	}

}
