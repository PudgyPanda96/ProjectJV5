package com.jv5.jv5backend.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.jv5.jv5backend.controllers.GameController;
import com.jv5.jv5backend.models.games.Game;

@Service
public class GameService {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GameService.class);
	
	public List<Game> getAllGames() {
		List<Game> allGames = mongoTemplate.findAll(Game.class);
		LOGGER.info("***Returning all games in db");
		return allGames;
	}
	
	public List<Game> createMultipleGames(List<Game> games) {
		
		for(Game g: games) {
			if(g.getGameId() == null) {
				String gameId = UUID.randomUUID().toString();
				g.setGameId(gameId);
			}
			Query query = new Query();
			query.addCriteria(Criteria.where("gameTitle").is(g.getGameTitle()));
			Game game = mongoTemplate.findOne(query, Game.class);
			if(game == null) {
				mongoTemplate.save(g, "games");
				LOGGER.info("***Saving game with title {}", g.getGameTitle());
			}
		}
		
	
		return games;
	}
	
	public Game createGame(Game game) {
		
		if(game.getGameId() == null) {
			String gameId = UUID.randomUUID().toString();
			game.setGameId(gameId);
		}
		
		Query query = new Query();
	
		query.addCriteria(Criteria.where("gameTitle").is(game.getGameTitle()));
		Game g = mongoTemplate.findOne(query, Game.class);
		if(g == null) {
			mongoTemplate.save(game, "games");
			LOGGER.info("***Saving game with title {}", game.getGameTitle());
		}
		
		return game;
	}
	
}
