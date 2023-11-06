<%@ page import="com.example.gk4.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.gk4.repositories.GrantAccessRepository" %>
<%@ page import="com.example.gk4.models.GrantAccess" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 11/3/2023
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <select name="role">
        <option>customer</option>
        <option>admin</option>
    </select>

    <button type="submit">Find</button>

</form>

<table>
    <tr>
        <th>Full Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Status</th>
        <th>Role</th>

    </tr>
    <% List<Account> accounts = (List<Account>) request.getAttribute("accounts");

    if(accounts != null){
        GrantAccessRepository grantAccessRepository = new GrantAccessRepository();
        for(Account account: accounts) {
            GrantAccess grantAccess = grantAccessRepository.findById(account.getId());
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
    <% }} %>


</table>

</body>
</html>
