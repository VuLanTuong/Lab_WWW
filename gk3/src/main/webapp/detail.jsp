<%@ page import="com.example.gk3.services.CandidateService" %>
<%@ page import="com.example.gk3.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 10/26/2023
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% CandidateService candidateService = new CandidateService();
    Candidate candidate = (Candidate) request.getAttribute("candidate");

%>
<table>
    <tr>
        <th>Full name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Experience</th>
    </tr>
   <tr>
       <th><%= candidate.getFullName() %></th>
       <th><%= candidate.getEmail() %></th>
       <th><%= candidate.getPhone() %></th>
       <th><%= candidate.getExperiences() %></th>
   </tr>
</table>

</body>
</html>
