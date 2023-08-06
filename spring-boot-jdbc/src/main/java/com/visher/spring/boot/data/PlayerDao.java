package com.visher.spring.boot.data;

import com.vishers.model.Player;
import com.vishers.model.PlayerDTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PlayerDao {

    private static class PlayerMapper implements RowMapper<Player> {
        @Override
        public Player mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(resultSet.getInt("id"));
            player.setName(resultSet.getString("name"));
            player.setNationality(resultSet.getString("nationality"));
            player.setBirthDate(resultSet.getDate("birth_date"));
            player.setTitles(resultSet.getInt("titles"));
            return player;
        }
    }

    private final JdbcTemplate jdbcTemplate;

    public PlayerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM PLAYER";
        return jdbcTemplate.query(sql, new PlayerMapper());
    }

    public Player getAllPlayerById(int id) {
        try {
            String sql = "SELECT * FROM PLAYER where id=?";
            return jdbcTemplate.queryForObject(sql, new PlayerMapper(), new Object[]{id});
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null if the object is not found
        }
    }

    public int deletePlayerById(int id) {
        String sql = "DELETE FROM PLAYER where id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    public int updatePlayer(int id, PlayerDTO player) {
        String sql = "UPDATE PLAYER SET Birth_date = ? , Titles = ? WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[]{
                new Timestamp(player.getBirthDate().getTime()), player.getTitles(), id});
    }

    public int save(Player player){
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                new Object[] {player.getId(), player.getName(), player.getNationality(),
                        new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
    }
}