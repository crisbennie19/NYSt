package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Roles;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Roles Userrole = new Roles("USER");
		List<Roles> roles = new ArrayList<>();
		roles.add(Userrole);
		user.setRole(roles);
		 userRepository.save(user);
	}
public void createAdmin(User user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Roles Userrole = new Roles("ADMIN");
		List<Roles> roles = new ArrayList<>();
		roles.add(Userrole);
		user.setRole(roles);
		userRepository.save(user);
	}
public User findOneUser(String email) {
	
	return userRepository.findOne(email);
}
}
