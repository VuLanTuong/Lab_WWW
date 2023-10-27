<%@ page import="com.example.gk3.services.CandidateService" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.gk3.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 10/26/2023
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <% CandidateService candidateService = new CandidateService();
     List<Candidate> candidateList = candidateService.findAll();
     System.out.println(candidateList);
 %>
<table class="table table-header">
  <tr>
    <th>Full Name</th>
  </tr>
    <%
    for(Candidate candidate : candidateList){
    %>
    <tr>
        <th><%= candidate.getFullName()%> </th>
        <th> <a href="/gk3?action=detail&id=<%=candidate.getId()%>">View</a></th>
    </tr>

    <%}%>
  <tr>

  </tr>

</table>

</body>
</html>
