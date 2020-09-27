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

import com.jv5.jv5backend.models.experience.Experience;
import com.jv5.jv5backend.models.experience.Experiences;
import com.jv5.jv5backend.services.ExperienceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/experience")
@Api(tags = "Experience", description = "Apis to manage Experience")
public class ExperienceController {
	
	@Autowired
	ExperienceService experienceService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExperienceService.class);
	
	
	@GetMapping("/all-experience")
	@ApiOperation("Get all experiences by userId")
	public List<Experience> getAllExperience() {
		return experienceService.getAllExperience();
	}
	
	@PostMapping("/create-new-experience")
	@ApiOperation("Create experience to the database")
	public Experience createNewExperience(@RequestBody Experience experience) {
		return experienceService.createNewExperience(experience);
	}
	
	@PostMapping("/add-new-experiences")
	@ApiOperation("Add a new experiences to the experiences array")
	public Experience addNewExperiences(@RequestParam String userId, @RequestBody Experiences experiences) {
		return experienceService.addNewExperience(userId, experiences);
	}
	
	@PutMapping("/update-experience/{userId}/experiences/experience")
	@ApiOperation("Update experience")
	public Experience updateExperience(@RequestParam String userId, @RequestBody Experience experience) {
		return experienceService.updateExperience(userId, experience);
	}
	
	@DeleteMapping("/delete-experiences/{expId}/{userId}")
	@ApiOperation("Delete experiences")
	public Experience deleteExperiences(@PathVariable("expId") String expId, @PathVariable("userId") String userId) {
		return experienceService.deleteExperiences(expId, userId);
	}

}
