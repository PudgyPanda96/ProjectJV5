package com.jv5.jv5backend.models.user;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

public class PlayerMetaData {
	
	@Field("player")
	private boolean player;
	
	@Field("commentator")
	private boolean commentator;
	
	@Field("teamOwner")
	private boolean teamOwner;
	
	@Field("onTeam")
	private boolean onTeam;
	
	@Field("currentTeam")
	private String currentTeam;
	
	@Field("mainGame")
	private String mainGame;
	
	@Field("secondaryGame")
	private String secondaryGame;
	
	@Field("tirtiaryGame")
	private String tirtiaryGame;

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

	public boolean isPlayer() {
		return player;
	}

	public void setPlayer(boolean player) {
		this.player = player;
	}

	public boolean isCommentator() {
		return commentator;
	}

	public void setCommentator(boolean commentator) {
		this.commentator = commentator;
	}

	public boolean isTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(boolean teamOwner) {
		this.teamOwner = teamOwner;
	}

	public boolean isOnTeam() {
		return onTeam;
	}

	public void setOnTeam(boolean onTeam) {
		this.onTeam = onTeam;
	}

	public String getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(String currentTeam) {
		this.currentTeam = currentTeam;
	}

	public String getMainGame() {
		return mainGame;
	}

	public void setMainGame(String mainGame) {
		this.mainGame = mainGame;
	}

	public String getSecondaryGame() {
		return secondaryGame;
	}

	public void setSecondaryGame(String secondaryGame) {
		this.secondaryGame = secondaryGame;
	}

	public String getTirtiaryGame() {
		return tirtiaryGame;
	}

	public void setTirtiaryGame(String tirtiaryGame) {
		this.tirtiaryGame = tirtiaryGame;
	}
	
	
	
}
