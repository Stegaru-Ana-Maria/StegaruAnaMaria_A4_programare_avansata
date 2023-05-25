package com.example.Lab11;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class PlayerService implements IPlayerService {
    @Override
    public List<Player> findAll() {

        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player(100, "Player1", '0'));
        players.add(new Player(101, "Player2", '1'));
        players.add(new Player(102, "Player3", '0'));
        players.add(new Player(103, "Player4", '1'));


        return players;
    }
}
