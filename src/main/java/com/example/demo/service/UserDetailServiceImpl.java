package com.example.demo.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	
	// to fetch user details from the db..
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if ("pk".equalsIgnoreCase(username)) {

			return new User("pk", "pk", Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + "User")));
		} else if ("prokarma".equalsIgnoreCase(username)) {

			return new User("prokarma", "prokarma",
					Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + "Admin")));
		} else {
			throw new UsernameNotFoundException("no user found");
		}

	}

}
