package com.example.gk4.db;

import org.hibernate.SessionFactory;

public class TestMapping {
    public static void main(String[] args) {
        SessionFactory sessionFactory = Connection.getInstance().getSessionFactory();
    }
}
