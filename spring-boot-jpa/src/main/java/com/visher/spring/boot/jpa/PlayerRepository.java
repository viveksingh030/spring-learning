package com.visher.spring.boot.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PlayerRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Player insertPlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player updatePlayer(Player player) {
        return entityManager.merge(player);
    }

    public Player getPlayerById(int id) {
        return entityManager.find(Player.class, id);
    }

    public int deletePlayerById(int id) {
        return entityManager.createQuery("delete from player where player=" + id).executeUpdate();
    }

    public List<Player> getAllPlayers() {
        TypedQuery<Player> query = entityManager.createQuery("SELECT p FROM Player p", Player.class);
        List<Player> players = query.getResultList();
        return players;
    }

}