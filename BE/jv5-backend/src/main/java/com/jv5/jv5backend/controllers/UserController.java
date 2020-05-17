package com.jv5.jv5backend.controllers;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	
	@GetMapping("/all-users")
	@ApiOperation("Get all users in the database")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/get-by-parmas")
	@ApiOperation("Get all users in the database that fit the given paramters")
	public List<User> getUsersByParams(
			@RequestParam(required = false) String mainGame,
			@RequestParam(required = false) String playsGame,
			@RequestParam(required = false) Boolean player,
			@RequestParam(required = false) Boolean commentator,
			@RequestParam(required = false) Boolean teamOwner,
			@RequestParam(required = false) Boolean onTeam,
			@RequestParam(required = false) String currentTeam) {
		return userService.getUsersByParams(mainGame, playsGame, player, commentator, teamOwner, onTeam, currentTeam);
	}
	
	@PostMapping("/create-new-user")
	@ApiOperation("Add a new user to the database")
	public User createNewUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}
	
	@PostMapping("/create-list-of-users")
	@ApiOperation("Create a list of users")
	public List<User> createListOfUsers(@RequestBody List<User> users) {
		return userService.createListOfUsers(users);
	}
	
	@GetMapping("/verify-user")
	@ApiOperation("Verify if a user put in correct information")
	public User verifyUser(
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String email,
			@RequestParam String password
			) {
		return userService.verifyUser(username, email, password);
	}
	
	@PutMapping("/update-username/{id}/{username}")
	@ApiOperation("Update username")
	public String updateUsername(@PathVariable String id, @PathVariable String username) {
		return userService.updateUsername(id, username);
	}
	
	@PutMapping("/{update-password/{id}/{password}")
	@ApiOperation("Update password")
	public String updatePassword(@PathVariable String id, @PathVariable String password) {
		return userService.updatePassword(id, password);
	}
	
	@PutMapping("/{update-email/{id}/{email}")
	@ApiOperation("Update email")
	public String updateEmail(@PathVariable String id, @PathVariable String email) {
		return userService.updateEmail(id, email);
	}
	
	@DeleteMapping("/delete-user/{id}")
	@ApiOperation("Delete User")
	public User deleteUser(@PathVariable("id") String id) {
		return userService.deleteUser(id);
	}

}
