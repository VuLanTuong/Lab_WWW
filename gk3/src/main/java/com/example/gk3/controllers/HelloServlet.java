package com.example.gk3.controllers;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.example.gk3.models.Candidate;
import com.example.gk3.models.Experience;
import com.example.gk3.models.Roles;
import com.example.gk3.services.CandidateService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "gk3", value = "/gk3")
public class HelloServlet extends HttpServlet {
    private String message;
    private CandidateService candidateService;

    public void init() {
        message = "Hello World!";
        candidateService = new CandidateService();
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action) {
            case "report1":
                handleReport1(request, response);
                return;
            case "report3":
                handleReport3(request, response);
        }
    }

    private void handleReport3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String temp = request.getParameter("date");

//        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // chuyen tu String sang local date
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate dt = LocalDate.parse(temp,dtf);

        List<Candidate> experiences = candidateService.findByDatye(dt);

        System.out.println(experiences);
        request.setAttribute("cans", experiences);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/report3.jsp");
        requestDispatcher.forward(request, response);
    }

    private void handleReport1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String temp = request.getParameter("chose");
                Roles role = Roles.valueOf(temp);

        List<Candidate> candidateList = new ArrayList<>();

        candidateList = candidateService.findByRole(role);
        request.setAttribute("candidates", candidateList);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/report1.jsp");
        requestDispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String action = request.getParameter("action");

       if(action != null) {

           switch (action) {
               case "listCandidate":
                   listCandidate(request, response);
               case "detail":
                   viewDetail(request, response);
               case "report1":
                   report1(request, response);
               case "report2":
                   report2(request, response);
               case "report3":
                   RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/report3.jsp");
                   requestDispatcher.forward(request, response);
           }
       }
    }

    private void report2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Candidate> candidateList = candidateService.findByEmail();
        request.setAttribute("candidates", candidateList);

    }

    private void report1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String role = request.getParameter("value");


        List<Candidate> candidateList = new ArrayList<>();

        if(role != null){
          candidateList = candidateService.findByRole(Roles.valueOf(role));
           request.setAttribute("candidates", candidateList);

       }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/report1.jsp");
        requestDispatcher.forward(request, response);
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Candidate candidate = new Candidate();
        candidate = candidateService.findById(id);

        request.setAttribute("candidate", candidate);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/detail.jsp");
        requestDispatcher.forward(request, response);


    }

    private void listCandidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/list_candidate.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }



    public void destroy() {
    }
}

