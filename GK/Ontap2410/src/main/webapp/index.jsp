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
<a class="btn btn-success" href="/controls?action=listStaff">List Staff</a>
</body>
</html>