package week3.vulantuong.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@Slf4j
@WebServlet("/control")
public class EmployeeController extends HttpServlet {


    public EmployeeController() {
    }

    @Override
    public void init() throws ServletException {
        log.info("init() called");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.println("<h1>Hello</h1>");
//        writer.println("<form>");
//        writer.println("<h1>" + "CLick menu " + "</h1>");
//        writer.println("<a href=\"dashboard.jsp\">Menu</a>");
//        writer.println("</form>");

//            log.info("RUNINGGGGGGGGGGGG");
//            getServletContext().getRequestDispatcher("/webapp/listing.jsp").forward(request, response);

                String action = request.getParameter("action");

        switch (action) {
            case "listing":
                response.sendRedirect("listing.jsp");
                break;
        }


       // getServletContext().getRequestDispatcher("/.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        switch (action) {
//            case "employeeList":
//                resp.sendRedirect("listing.jsp");
//                break;
//        }
    }



    @Override
    public void destroy() {
        log.info("destroy() called");
    }
}
