package org.example;

import javax.persistence.Persistence;

public class EntityManagerFactory {

    private static EntityManagerFactory instance;
    private javax.persistence.EntityManagerFactory entityManagerFactory;

    private EntityManagerFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    public static EntityManagerFactory getInstance() {
        if (instance == null) {
            instance = new EntityManagerFactory();
        }
        return instance;
    }

    public javax.persistence.EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void closeEntityManagerFactory() {
        entityManagerFactory.close();
    }
}