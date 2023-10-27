package com.example.gk4.controller;

import java.io.*;
import java.util.List;

import com.example.gk4.db.Connection;
import com.example.gk4.models.*;
import com.example.gk4.repositories.AccountRepository;
import com.example.gk4.services.AccountServices;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@WebServlet(name = "gk4", value = "/gk4")
public class HelloServlet extends HttpServlet {
    private String message;
    private AccountServices accountServices;


    public void init() {
        message = "Hello World!";
        accountServices = new AccountServices();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action){
            case "dashboard":
               handleDashBoard(request, response);
               return;
            case "update":
                handleGetUpdate(request, response);
            case "remove":
                System.out.println("HIIIIIIIII");
                handleRemove(request, response);
            case "testing":
                System.out.println("Em yeu Loc");
                Role role = new Role("1","hihi", "la", Status.ACTIVE );
                Account account = new Account("2","loc","hi@gmail", "123", "09876654", Status.ACTIVE );
                GrantAccess grantAccess = new GrantAccess(role, account, IsGrant.ENABLE, "tuong iu loc" );

                SessionFactory sessionFactory = Connection.getInstance().getSessionFactory();

                Session session = sessionFactory.openSession();
                Transaction transaction = null;
                try{
                    transaction = session.beginTransaction();

                    session.persist(role);
                    session.persist(account);
                    session.persist(grantAccess);
                    transaction.commit();


                }catch (Exception e){
                    e.printStackTrace();
                    if(transaction != null){
                        transaction.rollback();
                    }

                }
                finally {
                    session.close();
                }

        }
    }

    private void handleGetUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/update.jsp");
        requestDispatcher.forward(request, response);


    }

    private Account getAccount(HttpServletRequest request) {
        Account account = accountServices.findById(request.getParameter("id"));

        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Status status = null;
        if(request.getParameter("status") != null) {
             status = Status.valueOf(request.getParameter("status"));
        }
        String password = request.getParameter("password");

           account.setEmail(email);
           account.setFullName(fullName);
           account.setPassword(password);
           account.setPhone(phone);
           account.setStatus(status);
            return account;
    }

    private void handleDashBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = accountServices.getAllAccount();
        request.setAttribute("accounts", accounts);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String action = request.getParameter("action");
        switch (action){
            case "login":
                handleLogin(request, response);
                return;
            case "update":
                handleUpdate(request, response);return;
            case "testing":
                System.out.println("Em yeu Loc");
                Role role = new Role("1","hihi", "la", Status.ACTIVE );
                Account account = new Account("2","loc","hi@gmail", "123", "09876654", Status.ACTIVE );
                GrantAccess grantAccess = new GrantAccess(role, account, IsGrant.ENABLE, "tuong iu loc" );

                SessionFactory sessionFactory = Connection.getInstance().getSessionFactory();

                Session session = sessionFactory.openSession();
                Transaction transaction = null;
                try{
                    transaction = session.beginTransaction();
                    transaction.begin();
                    session.persist(role);
                    session.persist(account);
                    session.persist(grantAccess);
                    transaction.commit();


                }catch (Exception e){
                    e.printStackTrace();
                    if(transaction != null){
                        transaction.rollback();
                    }

                }
                finally {
                    session.close();
                }

        }
    }

    private void handleRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Account account = accountServices.findById(request.getParameter("id"));

        accountServices.remove(account);
        response.sendRedirect("/gk4?action=dashboard");

    }

    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Account account = getAccount(request);
        accountServices.update(account);
        response.sendRedirect("/gk4?action=dashboard");
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

       Account account = accountServices.isAccount(fullName, password);

       System.out.println(account);

       if(account != null){
            response.sendRedirect("/gk4?action=dashboard");
            return;
        }
        response.sendRedirect("/index.jsp");
        return;

    }

    public void destroy() {
    }
}