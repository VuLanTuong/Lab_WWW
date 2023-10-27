package com.example.gk4.db;

import com.example.gk4.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {

        Role role = new Role("1","hihi", "la", Status.ACTIVE );
        Account account = new Account("2","hi@gmail", "123", "09876654", Status.ACTIVE );
        GrantAccess grantAccess = new GrantAccess(role, account, IsGrant.ENABLE, "tuong iu loc" );

        SessionFactory sessionFactory = Connection.getInstance().getSessionFactory();

        Session session = sessionFactory.openSession();
        session.persist(grantAccess);
    }
}
