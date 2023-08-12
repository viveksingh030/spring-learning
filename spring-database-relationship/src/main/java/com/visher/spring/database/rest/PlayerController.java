package com.visher.spring.database.rest;

import com.visher.spring.database.onetoone.PlayerService;
import com.visher.spring.database.releationship.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    PlayerService service;

    @GetMapping("")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.allPlayers());
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("playerId") int playerId) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.findPlayer(playerId));
    }

    @PostMapping("")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.addPlayer(player));
    }

    @DeleteMapping("/player/{playerId}")
    public ResponseEntity addPlayer(@PathVariable("playerId") int playerId) {
        service.deletePlayer(playerId);
        return ResponseEntity.ok("");
    }

    //GET all players 
    //GET player by Id
    //POST player 
    //DELETE player 
}