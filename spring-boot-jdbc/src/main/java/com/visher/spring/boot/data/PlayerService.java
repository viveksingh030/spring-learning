package com.visher.spring.boot.data;

import com.vishers.model.Player;
import com.vishers.model.PlayerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private final PlayerDao playerDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public List<Player> getAllPlayers() {
        return playerDao.getAllPlayers();
    }

    public Player getAllPlayerById(int id) {
        return playerDao.getAllPlayerById(id);
    }

    public int deletePlayerById(int id) {
        return playerDao.deletePlayerById(id);
    }

    public int updatePlayer(int id, PlayerDTO player) {
        return playerDao.updatePlayer(id, player);
    }


    public int create(PlayerDTO playerDTO) {
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);
        return playerDao.save(player);
    }
}
