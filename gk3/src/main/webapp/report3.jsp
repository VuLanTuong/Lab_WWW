<%@ page import="com.example.gk3.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 10/27/2023
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Find by date</title>
</head>
<body>
<form method="post" action="/gk3?action=report3">
    Chose date for search<input name="date" type="date">
    <button type="submit">Find</button>
</form>
<table>
    <tr>
        <th>Full name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Experience</th>
    </tr>

    <%
        List<Candidate> candidateList = (List<Candidate>) request.getAttribute("cans");
        if(candidateList != null){
        for(Candidate candidate : candidateList){
    %>

    <tr>
        <th><%= candidate.getFullName() %></th>
        <th><%= candidate.getEmail() %></th>
        <th><%= candidate.getPhone() %></th>
        <th><%= candidate.getExperiences() %></th>
    </tr>

    <%
        }
    %>
</table>
<% }%>



</body>
</html>
