package com.visher.spring.database.onetoone;

import com.visher.spring.database.releationship.Player;
import com.visher.spring.database.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repo;

    public List<Player> allPlayers() {
        return repo.findAll();
    }

    public Player addPlayer(Player player) {
        player.setId(0);
        return repo.save(player);
    }

    public Player findPlayer(int id) {
        Optional<Player> byId = repo.findById(id);
        return byId.isPresent() ? byId.get() : null;
    }

    public void deletePlayer(int playerId) {
        repo.deleteById(playerId);
    }

    //...
}   