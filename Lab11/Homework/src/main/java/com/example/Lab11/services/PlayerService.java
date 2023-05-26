package com.example.Lab11.services;
import java.util.ArrayList;
import java.util.List;

import com.example.Lab11.entity.Player;
import org.springframework.stereotype.Service;
@Service
public class PlayerService implements IPlayerService {

    private List<Player> players = new ArrayList<>();
    private Long playerId = 1L;

    @Override
    public List<Player> findAll() {
        return players;
    }

    @Override
    public Player findById(Long id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    @Override
    public Player addPlayer(Player player) {
        player.setId(playerId++);
        players.add(player);
        return player;
    }

    @Override
    public Player updatePlayer(Player player) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == player.getId()) {
                players.set(i, player);
                return player;
            }
        }
        return null;
    }

    @Override
    public Player updatePlayerName(Long playerId, String newName) {
        Player player = findById(playerId);
        if (player != null) {
            player.setname(newName);
            return player;
        }
        return null;
    }

    @Override
    public void deletePlayer(Long playerId) {
        players.removeIf(player -> player.getId() == playerId);
    }


    /*
    @Override
    public List<Player> findAll() {

        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player(100, "Player1", '0'));
        players.add(new Player(101, "Player2", '1'));
        players.add(new Player(102, "Player3", '0'));
        players.add(new Player(103, "Player4", '1'));
        return players;
    }
     */
}
