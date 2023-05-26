package com.example.Lab11.controller;
import java.util.List;

import com.example.Lab11.services.IPlayerService;
import com.example.Lab11.entity.Player;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Player API")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;


    @Autowired
    public PlayerController(IPlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/player")
    @ApiOperation("Get all players")
    public List<Player> getPlayer()
    {

        List<Player> players = playerService.findAll();

        return players;
    }

    @PostMapping("/player")
    @ApiOperation("Add a new player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return ResponseEntity.ok(newPlayer);
    }

    @PutMapping("/player/{id}")
    @ApiOperation("Update player name")
    public ResponseEntity<Player> updatePlayerName(@PathVariable Long id, @RequestBody String name) {
        Player updatedPlayer = playerService.updatePlayerName(id, name);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/player/{id}")
    @ApiOperation("Delete a player by ID")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        Player player = playerService.findById(id);
        if (player == null) {
            return new ResponseEntity<>("Player not found", HttpStatus.GONE);
        }
        playerService.deletePlayer(id);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }



}
