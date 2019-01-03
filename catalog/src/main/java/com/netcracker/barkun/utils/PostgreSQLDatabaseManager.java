package com.netcracker.barkun.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostgreSQLDatabaseManager implements DatabaseManager {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("catalogPersistence");

    private EntityManager entityManager;

    private PostgreSQLDatabaseManager(){
        entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    private static class Holder{
        private final static DatabaseManager INSTANCE = new PostgreSQLDatabaseManager();
    }

    public static DatabaseManager getInstance(){return Holder.INSTANCE;}
}
