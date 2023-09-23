<%@ page import="com.example.week2.models.Employee" %>
<%@ page import="com.example.week2.services.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    EmployeeService employeeService = new EmployeeService();
            List<Employee> employeeList = employeeService.getAllEmp();
%>
<form action="employee?action=employeeList" method="get">
<table style="border-collapse: collapse;">
    <thead>
    <tr>
        <th style="border: 1px solid black;">Username</th>
        <th style="border: 1px solid black;">Fullname</th>
        <th style="border: 1px solid black;">Password</th>
        <th style="border: 1px solid black;">Email</th>
        <th style="border: 1px solid black;">Phone</th>
        <th style="border: 1px solid black;">Status</th>
    </tr>
    </thead>
    <tbody>
    <% for (Employee e : employeeList) { %>
    <tr>
        <td style="border: 1px solid black;"><%= e.getEmployeeId() %></td>
        <td style="border: 1px solid black;"><%=  e.getAddress() %></td>
        <td style="border: 1px solid black;"><%=  e.getDob().toLocalDate() %></td>
        <td style="border: 1px solid black;"><%= e.getEmail() %></td>
        <td style="border: 1px solid black;"><%=  e.getPhone() %></td>
        <td style="border: 1px solid black;"><%=  e.getStatus() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</form>
</body>
</html>