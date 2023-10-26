package com.example.gk3.db;

import jakarta.persistence.EntityManager;

public class Test {
    public static void main(String[] args) {
        EntityManager entityManager = Connection.getInstance().getEntityManager();
    }
}
