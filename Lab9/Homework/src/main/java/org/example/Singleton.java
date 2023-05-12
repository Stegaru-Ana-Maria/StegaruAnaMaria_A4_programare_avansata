package org.example;

import com.github.javafaker.Faker;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {

    public void insertAlbum(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Faker faker = new Faker();
        Artist artist = new Artist(faker.rockBand().name());
        Genre genre = new Genre(faker.music().genre());
        Album album = new Album(faker.number().numberBetween(1960, 2023), faker.book().title(), artist, genre);
        em.persist(artist);
        em.persist(genre);
        em.persist(album);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
