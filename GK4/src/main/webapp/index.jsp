<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<form method="post" action="/gk4?action=login">
  Username<input type="text" name="fullname">
  Password<input type="password" name="password">
  <br>
  <button type="submit">LOG IN</button>

</form>

</body>
</html>