package com.jv5.jv5backend.models.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

public class UserMetaData {
	
	@Field("country")
	private String country;
	
	@Field("state")
	private String state;
	
	@Field("dateCreated")
	private String dateCreated;
	
	@Field("firstName")
	private String firstName;
	
	@Field("lastName")
	private String lastName;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
