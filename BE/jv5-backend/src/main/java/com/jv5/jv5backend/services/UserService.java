package com.jv5.jv5backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.jv5.jv5backend.models.user.User;

@Service
public class UserService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<User> getAllUsers() {
		
		List<User> allUsers = mongoTemplate.findAll(User.class);
		return allUsers;
		
	}
	
}
