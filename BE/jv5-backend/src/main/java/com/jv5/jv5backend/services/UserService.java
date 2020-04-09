package com.jv5.jv5backend.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.jv5.jv5backend.controllers.GameController;
import com.jv5.jv5backend.models.user.User;

@Service
public class UserService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public List<User> getAllUsers() {
		
		List<User> allUsers = mongoTemplate.findAll(User.class);
		LOGGER.info("***Returning all users in db");
		return allUsers;
		
	}
	
}
