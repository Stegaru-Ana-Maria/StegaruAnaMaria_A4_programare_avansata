package org.example;

import java.util.List;
import javax.persistence.EntityManager;

public class AlbumRepository {

    private EntityManager em;

    public List<Album> findAll() {
        return em.createNamedQuery("Album.findAll")
                .getResultList();
    }

    public List<Album> findByTitle(String title) {
        return em.createNamedQuery("Album.findByTitle")
                .setParameter("title", title)
                .getResultList();
    }

    public List<Album> findByArtist(Artist artist) {
        return em.createNamedQuery("Album.findByArtist")
                .setParameter("artist", artist)
                .getResultList();
    }

    public List<Album> findByGenre(Genre genre) {
        return em.createNamedQuery("Album.findByGenre")
                .setParameter("genre", genre)
                .getResultList();
    }

}
