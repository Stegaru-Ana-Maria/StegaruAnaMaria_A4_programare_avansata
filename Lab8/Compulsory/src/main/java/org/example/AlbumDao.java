package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AlbumDao {

    public void create(int releaseYear, String title, String artistName, List<String> genres) throws SQLException {
        Connection con = Database.getConnection();
        Integer artistId = new ArtistDao().findByName(artistName);
        if (artistId == null) {
            throw new SQLException("Album not found: " + artistName);
        }
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year, title, artist_id) values (?, ?, ?)")) {
            pstmt.setInt(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setInt(3, artistId);
            pstmt.executeUpdate();
        }
        for (String genre : genres) {
            Integer genreId = new GenreDao().findByName(genre);
            if (genreId == null) {
                throw new SQLException("Genre not found: " + genre);
            }
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into album_genres (album_id, genre_id) values (?, ?)")) {
                pstmt.setInt(1, findAlbumIdByTitle(title));
                pstmt.setInt(2, genreId);
                pstmt.executeUpdate();
            }
        }
        con.commit();
    }

    public Integer findAlbumIdByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + title + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public List<String> findGenresByAlbumId(int albumId) throws SQLException {
        Connection con = Database.getConnection();
        List<String> genres = new ArrayList<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select genres.name from genres " +
                             "inner join album_genres on genres.id = album_genres.genre_id " +
                             "where album_genres.album_id=" + albumId)) {
            while (rs.next()) {
                genres.add(rs.getString(1));
            }
        }
        return genres;
    }


}

