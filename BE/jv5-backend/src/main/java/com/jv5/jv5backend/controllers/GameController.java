package com.jv5.jv5backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/games")
@Api(tags = "Games", description = "Apis to manage games")
public class GameController {

}
