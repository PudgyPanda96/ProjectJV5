package com.jv5.jv5backend.models.experience;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;

import com.jv5.jv5backend.models.experience.Experiences;

import lombok.Data;

@Document(collection = "experience")
public class Experience {
	
	@Field("userId")
	private String userId;
	
	@Field("experiences")
	private List<Experiences> experiences;

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getuserId() {
		return userId;
	}

	public void setId(String userId) {
		this.userId = userId;
	}

	public List<Experiences> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experiences> experiences) {
		this.experiences = experiences;
	}
	
	public void addExperiences(Experiences experiences) {
		this.experiences.add(experiences);
	}
}

