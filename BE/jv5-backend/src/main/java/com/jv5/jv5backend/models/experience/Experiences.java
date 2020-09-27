package com.jv5.jv5backend.models.experience;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

public class Experiences {
	
	@Field("expId")
	private String expId;
	
	@Field("game")
	private String game;
	
	@Field("description")
	private String description;
	
	@Field("year")
	private String year;
	
	@Field("event")
	private String event;

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

	public String getExpId() {
		return expId;
	}

	public void setExpId(String expId) {
		this.expId = expId;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
}
