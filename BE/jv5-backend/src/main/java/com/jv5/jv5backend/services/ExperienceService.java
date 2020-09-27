package com.jv5.jv5backend.services;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update; 
import org.springframework.stereotype.Service;

import com.jv5.jv5backend.models.experience.Experience;
import com.jv5.jv5backend.models.experience.Experiences;


@Service
public class ExperienceService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceService.class);
	
	
	public List<Experience> getAllExperience(){
		
		List<Experience> allExperience = mongoTemplate.findAll(Experience.class);
		LOGGER.info("***Returning arraylist of experiences for userID");
		return allExperience;
	}

	public Experience createNewExperience(Experience experience) {
		
		String userId = UUID.randomUUID().toString();
		experience.setId(userId);
		
		for (Experiences e : experience.getExperiences()) { 			
			e.setExpId(UUID.randomUUID().toString());
		}
		
		mongoTemplate.save(experience, "experience");
		LOGGER.info("***Created experience: ", experience.getuserId());
		
		return experience;
	}
	
	//Add a new experiences to the experiences array
	public Experience addNewExperience(String userId, Experiences experiences) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		Experience e = mongoTemplate.findOne(query,Experience.class);
		if (e == null) {
			LOGGER.info("***EXPERIENCE DOESNT EXIST***");
			return null;
		}
		
		e.addExperiences(experiences);
		
		Update update = new Update();
		update.push("experiences", experiences);
		mongoTemplate.updateFirst(query, update, "experience");
		
		LOGGER.info("***Added experience: ", experiences.getExpId());

		return e;
	}

	public Experience updateExperience(String userId,Experience experience) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		Experience e = mongoTemplate.findOne(query,Experience.class);
		if (e == null) {
			LOGGER.info("***ID DOESNT EXIST***");
			return null;
		}
		
		mongoTemplate.findAndRemove(query, Experience.class);
		
		createNewExperience(experience);
		return experience;
	}
	
	
	public Experience deleteExperiences(String expId, String userId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("expId").is(expId));
		Experiences es = mongoTemplate.findOne(query, Experiences.class);
		
		query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
		Experience e = mongoTemplate.findOne(query, Experience.class);
		if (e == null) {
			LOGGER.info("***ID DOESNT EXIST***");
			return null;
		}
		e.getExperiences().remove(es);
		
		Update update = new Update();
		update.push("experiences", es);
		mongoTemplate.updateFirst(query, update, "experience");
		
		return e;
	}
}
