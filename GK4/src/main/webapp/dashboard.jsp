<%@ page import="java.util.List" %>
<%@ page import="com.example.gk4.models.Account" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 9/15/2023
  Time: 5:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>

<table>
    <tr>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
    </tr>
    <% List<Account> accounts = (List<Account>) request.getAttribute("accounts");
            for(Account account: accounts){ %>
    <tr>
        <td><%= account.getFullName() %></td>
        <td><%= account.getEmail() %></td>
        <td><%= account.getPhone() %></td>
        <td><%= account.getStatus() %></td>
        <td><a href="/gk4?action=update&id=<%= account.getId()%>" >Edit</a></td>
        <td><a href="/gk4?action=remove&id=<%= account.getId()%>">Remove</a></td>

    </tr>

    <% } %>
</table>


</body>
</html>
