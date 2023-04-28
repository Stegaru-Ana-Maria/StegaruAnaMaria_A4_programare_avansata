package org.example;
import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final List<Token> tokens = new ArrayList<>();

    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    @Override
    public String toString() {
        return "Cell{tokens=" + tokens + "}";
    }
}