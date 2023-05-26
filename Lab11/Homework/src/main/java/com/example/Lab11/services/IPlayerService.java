package com.example.Lab11.services;
import com.example.Lab11.entity.Player;

import java.util.List;
public interface IPlayerService {
    List<Player> findAll();

    Player findById(Long id);

    Player addPlayer(Player player);

    Player updatePlayer(Player player);

    Player updatePlayerName(Long playerId, String newName);

    void deletePlayer(Long playerId);
}
