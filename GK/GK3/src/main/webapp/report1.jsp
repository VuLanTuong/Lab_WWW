<%@ page import="com.example.gk3.models.Roles" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.gk3.models.Candidate" %><%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 10/26/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/gk3?action=report1">
<h2>Select role</h2>
<select name="chose" id="role">

  <%
    for(Roles roles :Roles.values())
    {
  %>
  <option><%= roles%></option>

  <%
    }
  %>

</select>
<button  style="padding: 10px" type="submit">
<%--  <a id="link" onclick="handleRole()">View</a>--%>
<%--  <a href="/gk3?action=report1">View</a>--%>
  View
</button>
</form>
<%

  List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidates");
  if(candidateList != null){
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
 <% }%>

<script>
  function handleRole(){
    const role= document.getElementById("role");
    const value = role.value;
    document.getElementById("link").href = "/gk3?action=report1&value=" +value;

  }


</script>
</body>
</html>
