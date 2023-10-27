package com.fit.se.ontap2410.frontend.controllers;


import com.fit.se.ontap2410.backend.enums.StaffStatus;
import com.fit.se.ontap2410.backend.models.Staff;
import com.fit.se.ontap2410.backend.repositories.StaffRepository;
import com.fit.se.ontap2410.backend.services.StaffService;
import com.fit.se.ontap2410.frontend.models.StaffModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//Xu ly them xoa sua filter
@WebServlet(value = "/controls")
public class ServletController extends HttpServlet {
    private StaffService staffService;

    public ServletController() {
        staffService = new StaffService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {

            // handle insert
            case "insertStaff":
                StaffModel staffModel = new StaffModel();
                staffModel.insertStaff(req, resp);

                // quay lai trang list -> nho return
               resp.sendRedirect("/controls?action=listStaff");
                return;
            case "save":
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "listStaff":
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/list_staff.jsp");
                requestDispatcher.forward(req, resp);
                return;

                //display form insert
            case "insertStaff":
                requestDispatcher = getServletContext().getRequestDispatcher("/insert-staff.jsp");
                requestDispatcher.forward(req, resp);
        }
    }

    public void insertStaff(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        String name = request.getParameter("name");

        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = request.getParameter("checkin");

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        final LocalDate dt = LocalDate.parse(dateStr, dateFormatter);
        System.out.println(request.getParameter("checkin"));
        long id = Long.parseLong(request.getParameter("manager")); // Corrected parameter name
        Staff manager = null;
        if (staffService.getById(id).isPresent()) {
            manager = staffService.getById(id).get();
        }
        Staff staff = new Staff(name, age, address, LocalDateTime.of(dt, LocalTime.MAX), StaffStatus.ACTIVE, manager);

        System.out.println(staff);
        staffService.insertStaff(staff);
        resp.sendRedirect("list_staff.jsp");

    }
}
