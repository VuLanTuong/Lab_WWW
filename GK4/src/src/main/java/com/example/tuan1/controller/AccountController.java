package com.example.tuan1.controller;

import com.example.tuan1.models.Account;
import com.example.tuan1.services.AccountService;
import com.example.tuan1.services.impl.AccountImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
@WebServlet(name = "accountController", urlPatterns = "/register")
public class AccountController extends HttpServlet {

    private AccountImpl accountService;

    public AccountController() throws Exception {
        this.accountService = new AccountImpl();
    }

    @Override
    public void init() throws ServletException {
        log.info("init() called");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String[] pathInfo = req.getRequestURI().split("/");

        log.info("Test: {}", Arrays.toString(pathInfo));

        final String page = pathInfo[1];

        if ("register".equals(page)) {
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String[] pathInfo = req.getRequestURI().split("/");

        log.info("Test: {}", Arrays.toString(pathInfo));

        final String page = pathInfo[1];

        if ("register".equals(page)) {
            final String username = req.getParameter("username");
            final String password = req.getParameter("password");
            log.info("Username: {}, Password: {}", username, password);


            // dang nhap va tim account
            try {
                Account account=  accountService.findByUsernameAndPassword(username, password);
                if(account != null ) {


                    // check phai la admin hay khong
                    boolean admin = accountService.checkRoleAdmin(account);
                    log.info("Check Role{}", admin);

                    if(admin){
                        log.info("ADMIN");
                        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);

                    }
                    else{
                        req.setAttribute("full_name", account.getFull_name());
                        req.setAttribute("email", account.getEmail());
                        req.setAttribute("username", account.getAccount_id());
                        req.setAttribute("phone", account.getPhone());
                        req.setAttribute("role", "user");


                        //1-active, 0-deactive, -1-xóa

                        if(account.getStatus().getStatus() == 1){
                            req.setAttribute("status", "Active");

                        }
                        if(account.getStatus().getStatus() == 0){
                            req.setAttribute("status", "Deactive");

                        }
                        if(account.getStatus().getStatus() == -1){
                            req.setAttribute("status", "Delete");

                        }



                       getServletContext().getRequestDispatcher("/information.jsp").forward(req, resp);

                    }


//                    log.info("Account email: {}", account.getEmail());
//                    getServletContext().getRequestDispatcher("/logged.html").forward(req, resp);
                }
            } catch (SQLException e) {
                log.error("Error {}", e.getMessage(), e);
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void destroy() {
        log.info("destroy() called");
    }
}
