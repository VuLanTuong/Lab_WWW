package com.example.gk4.repositories;


import com.example.gk4.db.Connection;
import com.example.gk4.models.Account;
import com.example.gk4.models.Status;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AccountRepository {


    private SessionFactory sessionFactory;


    public AccountRepository() {
        sessionFactory = Connection.getInstance().getSessionFactory();
    }

    public Account isAccount(String fullName, String password){

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("select a from Account a where " +
           " a.fullName = :fullName and a.password = :password", Account.class);


            // name la sau dau =: name day
            query.setParameter("fullName", fullName);
            query.setParameter("password", password);
            Account account = (Account) query.getSingleResult();
            transaction.commit();

            return account;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }

        }
        return null;
    }

    public List<Account> getAllAccount(){
        Session session = sessionFactory.openSession();
        List<Account> accounts = session.createQuery("select a from Account  a", Account.class).getResultList();
        return accounts;
    }

    public Account findById(String id){
        Session session = sessionFactory.openSession();
        Account account = session.find(Account.class, id);
        session.close();
        return account;
    }

    public void update(Account account){
        System.out.println(account);
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(account);
            transaction.commit();

        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }


    public void remove(Account account){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(account);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }


//    public static void main(String[] args) {
//        AccountRepository accountRepository = new AccountRepository();
//        System.out.println(accountRepository.findById("1"));
//    }





}
