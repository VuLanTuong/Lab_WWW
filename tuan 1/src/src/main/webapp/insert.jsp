<%--
  Created by IntelliJ IDEA.
  User: 1805v
  Date: 9/17/2023
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="UserController?action=insert">
        Username <input type="text" name="username">
        <br>
        <br>
        Full Name <input type="text" name="fullname">
        <br>
        <br>
        Password <input type="password" name="password">
        <br>
        <br>
        Email <input type="text" name="email">
        <br>
        <br>
        Phone <input type="number" name="phone">
        <br>
        <br>
        <br>
        <button type="submit">Insert user</button>
    </form>

</body>
</html>
