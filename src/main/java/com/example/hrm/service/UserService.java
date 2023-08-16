package com.example.hrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrm.model.User;
import com.example.hrm.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(String userId) {
		return userRepository.findById(userId).get();
	}
}
