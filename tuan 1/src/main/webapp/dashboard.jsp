<%@ page import="java.util.List" %>
<%@ page import="com.example.gk4.models.Account" %>
<%@ page import="com.example.gk4.models.GrantAccess" %>
<%@ page import="com.example.gk4.repositories.GrantAccessRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
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
        <th>Role</th>
        <th>Edit</th>
        <th>Remove</th>
    </tr>
    <% List<Account> accounts = (List<Account>) request.getAttribute("accounts");
        GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
        for(Account account: accounts) {
            GrantAccess  grantAccess = grantAccessRepository.findById(account.getId());
    %>
    <tr>
        <td><%= account.getFullName() %></td>
        <td><%= account.getEmail() %></td>
        <td><%= account.getPhone() %></td>
        <td><%= account.getStatus() %></td>
        <td><%= grantAccess.getRole().getName()  %></td>
        <td><a href="/gk4?action=update&id=<%= account.getId()%>">Edit</a></td>
        <td><a href="/gk4?action=remove&id=<%= account.getId()%>">Remove</a></td>
    </tr>
    <% } %>


</table>
<button><a href="/gk4?action=insert">Insert account</a></button>
<button><a href="/gk4?action=findByRole">Find account by role</a></button>

</body>
</html>