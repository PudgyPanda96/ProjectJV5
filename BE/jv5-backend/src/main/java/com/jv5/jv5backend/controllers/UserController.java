package com.jv5.jv5backend.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv5.jv5backend.models.user.User;
import com.jv5.jv5backend.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users")
@Api(tags = "Users", description = "Apis to manage users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allUsers")
	@ApiOperation("Get all users in the database")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
