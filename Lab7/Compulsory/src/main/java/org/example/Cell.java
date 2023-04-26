package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private List<Token> tokens;
    private boolean visited;

    public Cell() {
        tokens = new ArrayList<>();
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean addToken(Token token) {
        return tokens.add(token);
    }

    public List<Token> getTokens() {
        return tokens;
    }
    public void removeToken(Token token) {
        this.tokens.remove(token);
    }

}