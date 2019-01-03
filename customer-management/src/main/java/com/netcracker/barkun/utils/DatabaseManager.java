package com.netcracker.barkun.utils;

import javax.persistence.EntityManager;

public interface DatabaseManager {
    EntityManager getEntityManager();
}
