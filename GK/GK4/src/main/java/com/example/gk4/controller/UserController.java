//package com.example.gk4.controller;
//
//
//import com.example.gk4.models.Account;
//import com.example.gk4.models.Status;
//import com.example.gk4.services.impl.AccountImpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.List;
//
//@Slf4j
//@WebServlet(urlPatterns = {"/UserController"})
//public class UserController extends HttpServlet {
//    private AccountImpl accountImp;
//
//    public UserController() throws Exception {
//        this.accountImp = new AccountImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        final String[] pathInfo = req.getRequestURI().split("/");
//////        getServletContext().getRequestDispatcher("/insert.jsp").forward(req, resp);
////        log.info("Test: {}", Arrays.toString(pathInfo));
////
////        final String page = pathInfo[2];
////
////        if ("insert".equals(page)) {
////            String username = req.getParameter("username");
////            String password = req.getParameter("password");
////            String fullname = req.getParameter("fullname");
////            String email = req.getParameter("email");
////            String phone = req.getParameter("phone");
////
////            Account account = new Account(username, fullname, password, email, phone, Status.ACTIVE);
////            log.info("Account {}", account.getAccount_id());
////            try {
////                accountImp.insertAccount(account);
////            } catch (Exception e) {
////                throw new RuntimeException(e);
////            }
////
////
//////            getServletContext().getRequestDispatcher("/insert.jsp").forward(req, resp);
////        }
//
//        String action = request.getParameter("action");
//
//        log.info("ACTION {}", action);
//
//        switch (action){
//            case "update":
//                try {
//                    handleUpdate(request, response);
//                    getServletContext().getRequestDispatcher("/update.jsp").forward(request, response);
//
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//
//
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String action = request.getParameter("action");
//        switch (action) {
//            case "insert":
//                try {
//                    handleInsert(request, response);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                break;
////
////            case "update":
////                try {
////                    handleUpdate(request, response);
////                } catch (SQLException e) {
////                    throw new RuntimeException(e);
////                }
////                break;
//
//
//        }
////        log.info("Action {}", action);
//    }
//
//    private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException {
//        List<Account> accountList;
//        accountList = accountImp.getAllAccount();
//
//        log.info("Account{}", accountList.get(0).getFull_name());
//
//
//            request.setAttribute("accountList", accountList);
//
//    }
//
//    private void handleInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String fullname = request.getParameter("fullname");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//
//
//        Account account = new Account(username, fullname, password, email, phone, Status.ACTIVE);
//        boolean result = accountImp.insertAccount(account);
//
//        if (result) {
//            response.setContentType("text/html");
//            PrintWriter writer = response.getWriter();
//            writer.println("<h2>Insert success</h2>");
//            writer.println("<a href=\"dashboard.jsp\">Menu</a>");
//
//        }
//    }
//}
