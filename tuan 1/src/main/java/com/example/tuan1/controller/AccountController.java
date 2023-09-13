package com.example.tuan1.controller;

import com.example.tuan1.models.Account;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.tuan1.repositories.AccountRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

@WebServlet(name = "accountController", urlPatterns = "/account/*")
public class AccountController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AccountController.class.getName());


    @Inject
    private AccountRepository accountRepository;


    public AccountController() {
    }

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void init() throws ServletException {
        LOGGER.info("init() called");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String[] pathInfo = req.getRequestURI().split("/");

        LOGGER.info(String.format("Test: %s", Arrays.toString(pathInfo)));

        final String page = pathInfo[3];

        if ("register".equals(page)) {
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String[] pathInfo = req.getRequestURI().split("/");

        LOGGER.info(String.format("Test: %s", Arrays.toString(pathInfo)));

        final String page = pathInfo[3];

        if ("register".equals(page)) {
            final String username = req.getParameter("username");
            final String password = req.getParameter("password");
            LOGGER.info(String.format("Username: %s, Password: %s", username, password));
            try {
                Account account=  accountRepository.findByUsernameAndPassword(username, password);
                if(account != null){
                    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                }
                else {
                    getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void destroy() {
        LOGGER.info("destroy() called");
    }
}
