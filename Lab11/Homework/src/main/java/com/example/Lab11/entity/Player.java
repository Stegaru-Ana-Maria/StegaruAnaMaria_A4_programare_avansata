package com.example.Lab11.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Player {
    private Long id;
    private String name;
    private char piece;

    public Player(Long id, String name, char piece) {
        this.id = id;
        this.name = name;
        this.piece = piece;
    }
    public long getId()
    {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getname()
    {
        return name;
    }
    public void setname(String name)
    {
        this.name = name;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }

}
