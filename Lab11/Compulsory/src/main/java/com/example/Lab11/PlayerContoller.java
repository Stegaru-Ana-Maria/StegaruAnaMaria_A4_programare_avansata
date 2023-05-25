package com.example.Lab11;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PlayerContoller {
    @Autowired
    private IPlayerService playerService;
    //mapping the getProduct() method to /product
    @GetMapping(value = "/player")
    public List<Player> getPlayer()
    {

        List<Player> players = playerService.findAll();

        return players;
    }
}
