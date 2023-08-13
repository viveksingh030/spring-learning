package com.visher.spring.boot.jpa;

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
        return playerService.getPlayerById(player);
    }

    @DeleteMapping("/players/{player}")
    public int deletePlayerById(@PathVariable("player") int player) {
        return playerService.deletePlayerById(player);
    }

    @PutMapping("/players/{player}/title/{title}")
    public Player get(@PathVariable("player") int player, @PathVariable("title") int title) {
        return playerService.updateTitles(player, title);
    }

    @PostMapping("/players")
    public Player save(@RequestBody Player player) {
        return playerService.save(player);
    }
}
