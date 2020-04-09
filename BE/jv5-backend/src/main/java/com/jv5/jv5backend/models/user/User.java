package com.jv5.jv5backend.models.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "users")
public class User {
	
	@Id
	@Field("id")
	private String id;
	
	@Field("username")
	private String username;
	
	@Field("password")
	private String password;
	
	@Field("email")
	private String email;
	
	@Field("userMetaData")
	private UserMetaData userMetaData;
	
	@Field("playerMetaData")
	private PlayerMetaData playerMetaData;
	
	

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserMetaData getUserMetaData() {
		return userMetaData;
	}

	public void setUserMetaData(UserMetaData userMetaData) {
		this.userMetaData = userMetaData;
	}

	public PlayerMetaData getPlayerMetaData() {
		return playerMetaData;
	}

	public void setPlayerMetaData(PlayerMetaData playerMetaData) {
		this.playerMetaData = playerMetaData;
	}
	
	
	
}
