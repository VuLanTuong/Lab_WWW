package com.example.gk4.controller;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import com.example.gk4.db.Connection;
import com.example.gk4.models.*;
import com.example.gk4.repositories.AccountRepository;
import com.example.gk4.repositories.GrantAccessRepository;
import com.example.gk4.repositories.LogRepository;
import com.example.gk4.repositories.RoleRepository;
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
    private GrantAccessRepository grantAccessRepository;
    private RoleRepository roleRepository;
     private LogRepository logRepository;


    public void init() {
        message = "Hello World!";
        accountServices = new AccountServices();
        grantAccessRepository = new GrantAccessRepository();
        roleRepository = new RoleRepository();
        logRepository = new LogRepository();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action) {
            case "dashboard":
                handleDashBoard(request, response);
                return;
            case "update":
                handleGetUpdate(request, response);
                return;
            case "remove":
                System.out.println("HIIIIIIIII");
                handleRemove(request, response);
                return;
            case "customer":
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/customer.jsp");
                requestDispatcher.forward(request, response);
                return;
            case "insert":
                RequestDispatcher requestDispatcher2 = getServletContext().getRequestDispatcher("/insert.jsp");
                requestDispatcher2.forward(request, response);
                return;
            case "findByRole"  :
                RequestDispatcher requestDispatcher3 = getServletContext().getRequestDispatcher("/find-role.jsp");
                requestDispatcher3.forward(request, response);
                return;


            case "testing":
//                System.out.println("Em yeu Loc");
//                Role role = new Role("1","hihi", "la", Status.ACTIVE );
//                Account account = new Account("2","loc","hi@gmail", "123", "09876654", Status.ACTIVE );
//                GrantAccess grantAccess = new GrantAccess(role, account, IsGrant.ENABLE, "tuong iu loc" );
//
//                SessionFactory sessionFactory = Connection.getInstance().getSessionFactory();
//
//                Session session = sessionFactory.openSession();
//                Transaction transaction = null;
//                try{
//                    transaction = session.beginTransaction();
//
//                    session.persist(role);
//                    session.persist(account);
//                    session.persist(grantAccess);
//                    transaction.commit();
//                }catch (Exception e){
//                    e.printStackTrace();
//                    if(transaction != null){
//                        transaction.rollback();
//                    }
//                }
//                finally {
//                    session.close();
//                }

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
        String roleName = request.getParameter("role");

        Status status = null;
        if (request.getParameter("status") != null) {
            status = Status.valueOf(request.getParameter("status"));
        }
        String password = request.getParameter("password");

//        Role role = roleRepository.findByName(roleName);


        account.setEmail(email);
        account.setFullName(fullName);
        account.setPassword(password);
        account.setPhone(phone);
        account.setStatus(status);
//        GrantAccess grantAccess = new GrantAccess(role, account, IsGrant.ENABLE, "update");
//        List<GrantAccess> temp = account.getGrantAccesses();
//        temp.add(grantAccess);
//        account.setGrantAccesses(temp);
        GrantAccess grantAccess = grantAccessRepository.findById(account.getId());
        Role role = roleRepository.findByName(roleName);
        grantAccess.setRole(role);

        List<GrantAccess> list = account.getGrantAccesses();
        list.add(grantAccess);
        account.setGrantAccesses(list);
        return account;
    }

    private void handleDashBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = accountServices.getAllAccount();
        request.setAttribute("accounts", accounts);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");
        switch (action) {
            case "login":
                handleLogin(request, response);
                return;
            case "update":
                handleUpdate(request, response);
                return;
            case "insert":
                handleInsert(request, response);
            case "findByRole"  :
                handleFindByRole(request, response);
        }
    }

    private void handleFindByRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String role = request.getParameter("role");
            List<Account> accounts = accountServices.findByRole(role);

            System.out.println("ACCOUNTS" + accounts);
            request.setAttribute("accounts", accounts);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/find-role.jsp");
        requestDispatcher.forward(request, response);
    }

    private void handleInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Account account = getAccount(request);
        accountServices.insert(account);
        response.sendRedirect("/gk4?action=dashboard");
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

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        System.out.println("HIIIIIIIIII");
        Account account = accountServices.isAccount(fullName, password);


//
//       System.out.println(account);
//        List<Account> accounts = accountServices.getAllAccount();
//
//        System.out.println(account);


        if (account != null) {

            GrantAccess grantAccess = grantAccessRepository.findById(account.getId());
            Log log = new Log(account, LocalDate.now(), "log in");

            logRepository.insert(log);


            if ("admin".equals(grantAccess.getRole().getName())) {

                System.out.println(grantAccess);

                request.setAttribute("grant", grantAccess);
//               response.sendRedirect("/gk4?action=dashboard");

//               RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/gk4?action=dashboard");
//               requestDispatcher.forward(request, response);

                response.sendRedirect("/gk4?action=dashboard");
                return;
            } else {

//               response.sendRedirect("/gk4?action=customer");
                request.setAttribute("account", account);

                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/customer.jsp");
                requestDispatcher.forward(request, response);
            }

        } else {
            response.sendRedirect("/index.jsp");
        }

    }

    public void destroy() {
    }
}