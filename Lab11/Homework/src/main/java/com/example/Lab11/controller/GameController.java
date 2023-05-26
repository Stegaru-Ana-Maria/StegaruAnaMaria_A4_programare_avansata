package com.example.Lab11.controller;

import com.example.Lab11.entity.Game;
import com.example.Lab11.services.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Api(tags = "Game API")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    @ApiOperation("Get recorded games")
    public ResponseEntity<List<Game>> getRecordedGames() {
        List<Game> games = gameService.getRecordedGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }
    private final String serverUrl = "http://localhost:8192";

    @GetMapping("/games")
    @ApiOperation("Get all games")
    public ResponseEntity<Game[]> getAllGames() {
        RestTemplate restTemplate = new RestTemplate();
        String url = serverUrl + "/games";
        return restTemplate.getForEntity(url, Game[].class);
    }

    @GetMapping("/games/{id}")
    @ApiOperation("Get a game by ID")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = serverUrl + "/games/" + id;
        return restTemplate.getForEntity(url, Game.class);
    }
}


