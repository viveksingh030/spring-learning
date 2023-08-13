package com.visher.spring.boot.jpa;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private final PlayerSpringDataRepository playerRepository;

    public PlayerService(PlayerSpringDataRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(int id) {
        Optional<Player> byId = playerRepository.findById(id);
        if (!byId.isPresent()) {
            throw new PlayerNotFoundException("Player is not found");
        }
        return byId.get();
    }

    public int deletePlayerById(int id) {
        Optional<Player> byId = playerRepository.findById(id);
        if(!byId.isPresent()){
            throw new PlayerNotFoundException("Player is not found");
        }
        playerRepository.deleteById(id);
        return 1;
    }

    public Player updateTitles(int id, int title) {
        Optional<Player> byId = playerRepository.findById(id);
        if(!byId.isPresent()){
            throw new PlayerNotFoundException("Player is not found");
        }
        Player player = byId.get();
        player.setTitles(title);
        return playerRepository.save(player);
    }

    public Player save(Player playerDTO) {
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);
        return playerRepository.save(player);
    }
}
