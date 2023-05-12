package org.example;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Album;

public class AlbumRepository {
    private static AlbumRepository instance;
    private static EntityManagerFactory emf;

    private AlbumRepository() {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static AlbumRepository getInstance() {
        if (instance == null) {
            instance = new AlbumRepository();
        }
        return instance;
    }

    public Album create(Album album) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
        return album;
    }

    public Album findById(int id) {
        EntityManager em = emf.createEntityManager();
        Album album = em.find(Album.class, id);
        em.close();
        return album;
    }

    public List<Album> findByName(String namePattern) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Album> query = em.createNamedQuery("Album.findByName", Album.class);
        query.setParameter("name", "%" + namePattern + "%");
        List<Album> albums = query.getResultList();
        em.close();
        return albums;
    }
}

