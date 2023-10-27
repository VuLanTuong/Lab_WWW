<%@ page import="com.example.gk4.models.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.gk4.services.AccountServices" %>
<%@ page import="com.example.gk4.models.Status" %><%--
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
<% Account account = new Account();
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
        </tr>

        <tr>
            <td>Full name<input value="<%= account.getFullName()%>" type="text" name="fullname"></td>
            <td>Email<input value="<%= account.getEmail()%>" type="text" name="email"></td>
            <td>Phone<input value="<%= account.getPhone()%>" type="text" name="phone"></td>
            <td>Password<input value="<%= account.getPassword()%>" type="text" name="password"></td>
            <select id="status" name="status">
                <%
                    if(Status.values() != null){
                   for(Status status :Status.values()){
                %>
                <option><%= status %></option>
                <%} }%>
            </select>
        </tr>
        <button type="submit">UPDATE</button>


    </table>
</form>
<script>
    // function handleStatus(){
    //     const temp= document.getElementById("status");
    //     const value = temp.value;
    //     document.getElementById("link").href = "/gk4?action=update&id=" +value;
    //
    // }

</script>
</body>
</html>
