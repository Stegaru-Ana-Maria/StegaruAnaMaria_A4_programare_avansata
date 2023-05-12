package org.example;

import java.util.List;
import javax.persistence.EntityManager;

public class ArtistRepository {
    private EntityManager em;

    public List<Artist> findById(int id) {
        return em.createNamedQuery("Artist.findById")
                .setParameter("id", id)
                .getResultList();
    }

    public List<Artist> findByName(String name) {
        return em.createNamedQuery("Artist.findByName")
                .setParameter("name", name)
                .getResultList();
    }
}