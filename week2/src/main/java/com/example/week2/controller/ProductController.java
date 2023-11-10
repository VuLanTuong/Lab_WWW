//package com.example.week2.controller;
//
//import com.example.week2.models.Customer;
//import com.example.week2.services.ProductService;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@Slf4j
//@WebServlet(value = "/week2")
//public class ProductController extends HttpServlet {
//    private ProductService  productService;
//
//    public ProductController() {
//        productService = new ProductService();
//    }
//
//    @Override
//    public void init() throws ServletException {
//        log.info("init() called");
//    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action")  ;
//        switch (action){
//            case "dashboard":
//                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
//                requestDispatcher.forward(request, response);
//
//        }
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        switch (action) {
//
//        }}
//
//
//
//    @Override
//    public void destroy() {
//        log.info("destroy() called");
//    }
//
//}
