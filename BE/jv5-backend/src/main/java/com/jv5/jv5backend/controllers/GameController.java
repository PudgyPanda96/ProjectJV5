package com.jv5.jv5backend.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv5.jv5backend.models.games.Game;
import com.jv5.jv5backend.services.GameService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/games")
@Api(tags = "Games", description = "Apis to manage games")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);
	
	@GetMapping("/all-games")
	@ApiOperation("Get all games in the database")
	public List<Game> getAllGames() {
		return gameService.getAllGames();
	}
	
	@PostMapping("/create-games")
	@ApiOperation("Create a list of games to add to the database")
	public List<Game> createMultipleGames(@RequestBody List<Game> games) {
		return gameService.createMultipleGames(games);
	}
	
	@PostMapping("/create-game")
	@ApiOperation("Create and add a new game to the database")
	public Game createGame(@RequestBody Game game) {
		return gameService.createGame(game);
	}
	
}
