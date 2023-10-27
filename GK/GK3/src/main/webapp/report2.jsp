<%@ page import="com.example.gk3.models.Candidate" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 10/26/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidates");
%>
<table>
    <tr>
        <th>Full name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Experience</th>
    </tr>
    <%
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


</body>
</html>
