<%@ page import="com.example.tuan1.models.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 9/17/2023
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="UserController?action=update">
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
        <% for (Account a : (List<Account>) request.getAttribute("accountList")) { %>
        <tr>
            <td style="border: 1px solid black;"><%= a.getAccount_id() %></td>
            <td style="border: 1px solid black;"><%= a.getFull_name() %></td>
            <td style="border: 1px solid black;"><%= a.getPassword() %></td>
            <td style="border: 1px solid black;"><%= a.getEmail() %></td>
            <td style="border: 1px solid black;"><%= a.getPhone() %></td>
            <td style="border: 1px solid black;"><%= a.getStatus() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</form>

</body>
</html>
