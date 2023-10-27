<%@ page import="com.fit.se.ontap2410.backend.services.StaffService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fit.se.ontap2410.backend.models.Staff" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Home Page</title>
  <%@include file="cdn.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<h1 class="text-center">Staff Management</h1>
<a class="btn btn-success" href="/controls?action=insertStaff">ADD STAFF</a>
<div class="container">
  <table class="table table-hover">
    <thead>
    <tr>
      <th>STT</th>
      <th>Name</th>
      <th>Age</th>
      <th>Address</th>
      <th>Check-in At</th>
      <th>Manager</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
      StaffService staffService = new StaffService();
      List<Staff> staffs = staffService.getAll();
      int stt = 0;
      for (Staff staff : staffs) {
        stt++;

    %>
    <tr>
      <td><%= stt %>
      </td>
      <td><%= staff.getName() %>
      </td>
      <td><%= staff.getAge() %>
      </td>
      <td><%= staff.getAddress() %>
      </td>
      <td><%= staff.getCheckInAt() %>
      </td>
      <%
        Staff manager = staff.getManager();
        String text = "";
        if (manager == null) {
          text = "MANGER";
        } else {
          text = "Manager is" + manager.getName();
        }
      %>
      <td><%= text
      %>
      </td>
      <td>
        <a class="btn btn-danger" href="#">DELETE</a>
        <a class="btn btn-warning" href="#">EDIT</a>
      </td>
    </tr>

    <%
      }
    %>
    </tbody>
  </table>
</div>
</body>
</html>