package com.keyin.rest.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/player")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id) {
        Player player = playerService.getPlayerById(id);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/player")
    public ResponseEntity<Player> createPlayer(@RequestBody Player newPlayer) {
        Player createdPlayer = playerService.createPlayer(newPlayer);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable long id, @RequestBody Player updatedPlayer) {
        Player updated = playerService.updatePlayer(id, updatedPlayer);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> deletePlayerById(@PathVariable long id) {
        playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
