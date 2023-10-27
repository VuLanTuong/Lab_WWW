package com.example.tuan1.controller;


import jakarta.enterprise.inject.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/dashboard"})
public class ControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // get acction
        String action = request.getParameter("action");
        request.setAttribute("action", action);

//        final String[] pathInfo = request.getRequestURI().split("/");
//        final String page = pathInfo[3];
//
//        // dua gia tri qua file jsp
//        if ("register".equals(page)) {
//            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
//        }
//  <form action="post">
//        <a href="/register">Dang Nhap</a>
//    </form>

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Hello</h1>");
        writer.println("<form>");
        writer.println("<h1>" + "CLick menu " + "</h1>");
        writer.println("<a href=\"dashboard.jsp\">Menu</a>");
        writer.println("</form>");
//        writer.println();




    }

}
