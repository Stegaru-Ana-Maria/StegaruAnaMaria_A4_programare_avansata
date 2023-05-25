package com.example.Lab11;

public class Player {
    private int id;
    private String name;

    private char piece;

    public Player(int id, String name, char piece) {
        super();
        this.id = id;
        this.name = name;
        this.piece = piece;
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
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
