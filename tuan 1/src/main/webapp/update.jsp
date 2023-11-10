<%@ page import="com.example.gk4.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.gk4.services.AccountServices" %>
<%@ page import="com.example.gk4.models.Status" %>
<%@ page import="com.example.gk4.models.Role" %>
<%@ page import="com.example.gk4.repositories.GrantAccessRepository" %>
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

        input[type="text"] {
            width: 100%;
            padding: 6px 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        select {
            width: 100%;
            padding: 6px 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button[type="submit"] {
            margin-top: 10px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%
    Account account = new Account();
    AccountServices accountServices = new AccountServices();
    account = accountServices.findById(request.getParameter("id"));
%>
<form method="post">
    <table>
        <tr>
            <th>Full Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Password</th>
            <th>Status</th>
            <th>Role</th>
        </tr>

        <tr>
            <td>Full name<input value="<%= account.getFullName()%>" type="text" name="fullname"></td>
            <td>Email<input value="<%= account.getEmail()%>" type="text" name="email"></td>
            <td>Phone<input value="<%= account.getPhone()%>" type="text" name="phone"></td>
            <td>Password<input value="<%= account.getPassword()%>" type="text" name="password"></td>
            <td>
                <select id="status" name="status">
                    <%
                        if (Status.values() != null) {
                            for (Status status : Status.values()) {
                    %>
                    <option <%= (status == account.getStatus()) ? "selected" : "" %>><%= status %></option>
                    <% } } %>
                </select>
            </td>
            <%
                GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
                Role role = grantAccessRepository.findById(account.getId()).getRole();
            %>
            <td>
                <select name="role">
                    <option>customer</option>
                    <option>admin</option>
                </select>
            </td>
        </tr>
    </table>
    <button type="submit">UPDATE</button>
</form>
</body>
</html>