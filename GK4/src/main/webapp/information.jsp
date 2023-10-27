<%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 9/15/2023
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>Username</h2>
    <p id="username"><%= request.getAttribute("username") %></p>
    <h2>Full name</h2>
    <p id="full_name"><%= request.getAttribute("full_name") %></p>
    <h2>Email</h2>
    <p id="email"><%= request.getAttribute("email") %></p>
    <h2>Phone</h2>
    <p id="phone"><%= request.getAttribute("phone") %></p>
    <h2>Status</h2>
    <p id="status"><%= request.getAttribute("status") %></p>
    <h2>Role</h2>
    <p id="role"><%= request.getAttribute("role") %></p>



</body>
</html>
