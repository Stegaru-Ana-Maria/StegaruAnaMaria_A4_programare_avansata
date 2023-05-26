package com.example.Lab11.services;

import com.example.Lab11.entity.Game;
import java.util.Date;

import java.util.List;

public interface IGameService {
    List<Game> getAllGames();

    List<Game> getRecordedGames();

    void addRecordedGame(Game game);

    Game getGameById(Long id);

    Game createGame(Game game);

    Game updateGame(Game game);

    void deleteGame(Long id);
}
