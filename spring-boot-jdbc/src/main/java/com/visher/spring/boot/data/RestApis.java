package com.visher.spring.boot.data;

import com.vishers.model.Player;
import com.vishers.model.PlayerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApis {
    private final PlayerService playerService;

    public RestApis(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> get() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{player}")
    public Player getPlayerById(@PathVariable("player") int player) {
        return playerService.getAllPlayerById(player);
    }

    @DeleteMapping("/players/{player}")
    public int deletePlayerById(@PathVariable("player") int player) {
        return playerService.deletePlayerById(player);
    }

    @PutMapping("/players/{player}")
    public int get(@PathVariable("player") int player, @RequestBody PlayerDTO playerDTO) {
        return playerService.updatePlayer(player, playerDTO);
    }

    @PostMapping("/players")
    public int get(@RequestBody PlayerDTO player) {
        return playerService.create(player);
    }
}
