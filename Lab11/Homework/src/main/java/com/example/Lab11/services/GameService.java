package com.example.Lab11.services;

import com.example.Lab11.entity.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Service
public class GameService implements IGameService{
    private List<Game> recordedGames;

    public GameService() {
        this.recordedGames = new ArrayList<>();
    }

    @Override
    public List<Game> getAllGames() {
        return recordedGames;
    }

    @Override
    public Game getGameById(Long id) {
        for (Game game : recordedGames) {
            if (game.getId().equals(id)) {
                return game;
            }
        }
        return null;
    }

    public List<Game> getRecordedGames() {
        return recordedGames;
    }

    public void addRecordedGame(Game game) {
        recordedGames.add(game);
    }

    @Override
    public Game createGame(Game game) {
        recordedGames.add(game);
        return game;
    }

    @Override
    public Game updateGame(Game game) {
        for (int i = 0; i < recordedGames.size(); i++) {
            if (recordedGames.get(i).getId().equals(game.getId())) {
                recordedGames.set(i, game);
                return game;
            }
        }
        return null;
    }

    @Override
    public void deleteGame(Long id) {
        recordedGames.removeIf(game -> game.getId().equals(id));
    }
}
