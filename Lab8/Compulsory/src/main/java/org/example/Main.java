package org.example;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
public class Main {
    public static void main(String args[]) {
        try {
            var artists = new ArtistDao();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");

            var genres = new GenreDao();
            genres.create("Rock");
            Database.getConnection().commit();

            var albums = new AlbumDao();
            albums.create(1979, "The Wall", "Pink Floyd", Collections.singletonList("Rock"));
            albums.create(1982, "Thriller", "Michael Jackson", Collections.singletonList("Funk,Soul,Pop"));
                    Database.getConnection().commit();


            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}