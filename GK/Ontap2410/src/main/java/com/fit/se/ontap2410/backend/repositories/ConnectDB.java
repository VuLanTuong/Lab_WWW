package com.fit.se.ontap2410.backend.repositories;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;
    private final EntityManagerFactory emf;

    public ConnectDB() {
        emf = Persistence.createEntityManagerFactory("ontap");
    }

    public static ConnectDB getInstance() {
        if(instance == null){
            instance = new ConnectDB();
        }
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
}
