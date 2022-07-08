package org.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {


    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {


        if (entityManager == null) {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("crmtp");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}
