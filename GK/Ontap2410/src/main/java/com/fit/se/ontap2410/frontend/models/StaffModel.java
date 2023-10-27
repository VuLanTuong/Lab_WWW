package com.fit.se.ontap2410.frontend.models;

import com.fit.se.ontap2410.backend.converters.ObjectMapperContextResolver;
import com.fit.se.ontap2410.backend.converters.StaffStatusConverter;
import com.fit.se.ontap2410.backend.enums.StaffStatus;
import com.fit.se.ontap2410.backend.models.Staff;
import com.fit.se.ontap2410.backend.repositories.StaffRepository;
import com.fit.se.ontap2410.backend.services.StaffService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StaffModel {
    private final StaffService staffService = new StaffService();

    public boolean insertStaff(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateStr = request.getParameter("checkin");

        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
        final LocalDate dt = LocalDate.parse(dateStr,dateFormatter);
        System.out.println(request.getParameter("checkin"));

        long id = Long.parseLong(request.getParameter("manager")); // Corrected parameter name
        Staff manager = null;

        if (staffService.getById(id).isPresent()) {
            manager = staffService.getById(id).get();
        }

        Staff staff = new Staff(name, age, address,LocalDateTime.of(dt,LocalTime.MAX), StaffStatus.ACTIVE, manager);

        System.out.println(staff);
         staffService.insertStaff(staff);
         return true;
//        response.sendRedirect("list_staff.jsp");


    }
}
