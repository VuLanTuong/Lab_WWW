package com.example.gk4.repositories;


import com.example.gk4.db.Connection;
import com.example.gk4.models.Account;
import com.example.gk4.models.Status;
import jakarta.persistence.NoResultException;
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

    public Account isAccount(String fullName, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("select a from Account a where " +
                    "a.fullName = :fullName and a.password = :password", Account.class);

            query.setParameter("fullName", fullName);
            query.setParameter("password", password);

            List<Account> results = query.getResultList();
            if (!results.isEmpty()) {
                Account account = results.get(0);
                return account;
            }
        } catch (NoResultException e) {
            // Handle the case when no account is found
            // You can log an error message or return null, depending on your requirement
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public List<Account> getAllAccount(){
        Session session = sessionFactory.openSession();
        List<Account> accounts = session.createQuery("select a from Account  a", Account.class).getResultList();
        session.close();
        return accounts;
    }

    public Account findById(String id){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Account account = session.find(Account.class, id);
            transaction.commit();
            return account;

        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return null;
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

    public void insert(Account account){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(
                    account);
            transaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public List<Account> findByRole(String role){
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            List<Account> accounts = session.createQuery(
                    "select g.account from GrantAccess g join Role" +
                            " r on g.role = r where r.name = :role")
                    .setParameter("role", role)
                            .getResultList();
            transaction.commit();
            return accounts;
        }
        catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return null;
    }


    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
        System.out.println(accountRepository.findByRole("admin"));
    }





}
