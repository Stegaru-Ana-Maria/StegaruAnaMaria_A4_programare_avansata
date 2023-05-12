package org.example;

import java.util.List;
import javax.persistence.EntityManager;

public class GenreRepository {
    private EntityManager em;

    public List<Genre> findById(int id) {
        return em.createNamedQuery("Genre.findById")
                .setParameter("id", id)
                .getResultList();
    }

    public List<Genre> findByName(String name) {
        return em.createNamedQuery("Genre.findByName")
                .setParameter("name", name)
                .getResultList();
    }
}