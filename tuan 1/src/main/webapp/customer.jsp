<%@ page import="com.example.gk4.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        a {
            text-decoration: none;
            color: #337ab7;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th>Edit</th>
        <!-- <th>Remove</th> -->
    </tr>
    <% Account account = (Account) request.getAttribute("account");
        if(account != null)   { %>
    <tr>
        <td><%= account.getFullName() %></td>
        <td><%= account.getEmail() %></td>
        <td><%= account.getPhone() %></td>
        <td><%= account.getStatus() %></td>
<%--        <td><a href="/gk4?action=update&id=<%= account.getId()%>" >Edit</a></td>--%>
        <!-- <td><a href="/gk4?action=remove&id=<%= account.getId()%>">Remove</a></td> -->
    </tr>
    <% }%>
</table>
</body>
</html>