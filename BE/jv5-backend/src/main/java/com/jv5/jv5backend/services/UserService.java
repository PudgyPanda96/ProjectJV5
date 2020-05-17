package com.jv5.jv5backend.services;

import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update; 
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	/* Create a list for each parameter
	 * Remove from the lists when users don't exist in other lists
	 */
	public List<User> getUsersByParams(
			String mainGame,
			String playsGame,
			Boolean player,
			Boolean commentator,
			Boolean teamOwner,
			Boolean onTeam,
			String currentTeam) {
		
		List<User> mainGameUsers = new ArrayList<User>();
		List<User> playsGameUsers = new ArrayList<User>();;
		List<User> playerUsers = new ArrayList<User>();
		List<User> commentatorUsers	= new ArrayList<User>();
		List<User> teamOwnerUsers = new ArrayList<User>();
		List<User> onTeamUsers = new ArrayList<User>();
		List<User> currentTeamUsers = new ArrayList<User>();
		List<User> finalList = new ArrayList<User>();
		List<List> listOfLists = new ArrayList<List>();
		
		
		if (mainGame != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.mainGame").is(mainGame));
			mainGameUsers = mongoTemplate.find(query, User.class);
			listOfLists.add(mainGameUsers);
		}
		if (playsGame != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.mainGame").is(playsGame));
			playsGameUsers = mongoTemplate.find(query, User.class);
			
			query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.secondaryGame").is(playsGame));
			playsGameUsers.addAll(mongoTemplate.find(query, User.class));
			
			query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.tirtiaryGame").is(playsGame));
			playsGameUsers.addAll(mongoTemplate.find(query, User.class));
			listOfLists.add(playsGameUsers);
		}
		
		if (player != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.player").is(player));
			playerUsers = mongoTemplate.find(query, User.class);
			listOfLists.add(playerUsers);
		}
		
		if (commentator != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.commentator").is(commentator));
			commentatorUsers = mongoTemplate.find(query, User.class);
			listOfLists.add(commentatorUsers);
		}
		
		if (teamOwner != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.teamOwner").is(teamOwner));
			teamOwnerUsers = mongoTemplate.find(query, User.class);	
			listOfLists.add(teamOwnerUsers);
		}
		if (onTeam != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.onTeam").is(onTeam));
			onTeamUsers = mongoTemplate.find(query, User.class);	
			listOfLists.add(onTeamUsers);
		}
		if (currentTeam != null) {
			Query query = new Query();
			query.addCriteria(Criteria.where("playerMetaData.currentTeam").is(currentTeam));
			currentTeamUsers = mongoTemplate.find(query, User.class);	
			listOfLists.add(currentTeamUsers);
		}
		
			
		if (listOfLists.get(0).size() == 0) {
			LOGGER.info("***RETURNING EMPTY LIST***");
			return null;
		}
		
		finalList = listOfLists.get(0);
		
		if (playsGame != null)
			finalList = combineLists(finalList,playsGameUsers);
		if (player != null)
			finalList = combineLists(finalList,playerUsers);
		if (commentator != null)
			finalList = combineLists(finalList,commentatorUsers);
		if (teamOwner != null)
			finalList = combineLists(finalList,teamOwnerUsers);
		if (onTeam != null)
			finalList = combineLists(finalList,onTeamUsers);
		if (currentTeam != null)
			finalList = combineLists(finalList,currentTeamUsers);
		
		
		LOGGER.info("***RETURNING USERS BY PARAMETERS***");
		return finalList;
	}
	
	
	/* Find which list is biggest
	 * Remove from the list based on id
	 * "If list has something that is not in finalList, remove it from list"
	 */
	public List<User> combineLists(List<User> finalList, List<User> list){
		
		if (list.size() == 0)
			return list;
		
		List<String> idListFinal = new ArrayList<String>();
		for (int i = 0; i < finalList.size(); i++) {
			idListFinal.add(finalList.get(i).getId());
		}
		List<String> idList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			idList.add(list.get(i).getId());
		}	
		
		//remove from list
		if (list.size() >= finalList.size()) {
			for (int i=0; i < list.size(); i++) {
				
				if (!idListFinal.contains(idList.get(i)))
					list.remove(list.get(i));
			}
			
			finalList = list;
			
		}
		//remove from finalList
		else {
			for (int i=0; i < finalList.size(); i++) {
				
				if (!idList.contains(idListFinal.get(i)))
					finalList.remove(i);
			}
		}
						
		return finalList;	
		/*
		//Create a list with distinct elements using stream
		List<User> listDistinct = finalList.stream().distinct().collect(Collectors.toList());
		
		//removes unique values because you only want to carry duplicates into the final list
		finalList.removeIf( unique -> listDistinct.contains(unique) );
		
		//remove duplicates to finalList and continue to next list
		finalList.stream().distinct().collect(Collectors.toList());
		
		return finalList;
		*/
	}

	public User createNewUser(User user) {
		
		String userId = UUID.randomUUID().toString();
		user.setId(userId);
		
		Query query = new Query();
		
		query.addCriteria(Criteria.where("username").is(user.getUsername()));
		User u = mongoTemplate.findOne(query, User.class);
		if (u == null) {
			mongoTemplate.save(user, "users");
			LOGGER.info("***Created user: ", user.getUsername());
		}
		
		return user;
	}
	
	public List<User> createListOfUsers(List<User> users){
		
		for (User u: users) {
			String userId = UUID.randomUUID().toString();
			u.setId(userId);
			
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(u.getId()));
			User user = mongoTemplate.findOne(query, User.class);
			if (user == null) {
				mongoTemplate.save(u, "users");
				LOGGER.info("Created user: ", u.getUsername());
			}
		}
		return users;
	}

	public User verifyUser(
			String username,
			String email,
			String password
			) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		User u = mongoTemplate.findOne(query, User.class);
		if (u != null) {
			LOGGER.info("***USERNAME ALREADY EXISTS***");
			return u;
		}
		
		query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		u = mongoTemplate.findOne(query, User.class);
		if (u != null) {
			LOGGER.info("***EMAIL ALREADY EXISTS***");
			return u;
		}
		
		return u;
	}
	
	public String updateUsername(String id, String username) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username));
		User u = mongoTemplate.findOne(query, User.class);
		if (u != null) {
			LOGGER.info("***USERNAME ALREADY EXISTS***");
			return null;
		}
		
		query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		User user = mongoTemplate.findOne(query,User.class);
		if (user == null) {
			LOGGER.info("***ID DOESNT EXIST***");
			return null;
		}
		
		user.setUsername(username);
		
		Update update = new Update();
		update.set("username", username);
		
		mongoTemplate.updateFirst(query, update, User.class);
		
		LOGGER.info("***UPDATED TO: {}", user.getUsername());
		return user.getId();
		
	}
	
	public String updatePassword(String id, String password) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		User user = mongoTemplate.findOne(query,User.class);
		if (user == null) {
			LOGGER.info("***ID DOESNT EXIST***");
			return null;
		}
		user.setPassword(password);
		
		Update update = new Update();
		update.set("password", password);
		
		mongoTemplate.updateFirst(query, update, User.class);
		LOGGER.info("***UPDATED TO: {}", user.getPassword());
		return user.getId();
	}

	public String updateEmail(String id, String email) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		User user = mongoTemplate.findOne(query,User.class);
		if (user == null) {
			LOGGER.info("***ID DOESNT EXIST***");
			return null;
		}
		user.setEmail(email);
		
		Update update = new Update();
		update.set("email", email);
		
		mongoTemplate.updateFirst(query, update, User.class);
		LOGGER.info("***UPDATED TO: {}", user.getEmail());
		return user.getId();

	}
	
	public User deleteUser(String userId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId));
		User user = mongoTemplate.findOne(query, User.class);
		if (user == null) {
			LOGGER.info("***USER DOES NOT EXIST***");
			return user;
		}
		
		mongoTemplate.findAndRemove(query, User.class);
		LOGGER.info("***ok the remove code ran but idk if it worked go check the db if this is here: {}", userId);
		
		return user;
	}

}
