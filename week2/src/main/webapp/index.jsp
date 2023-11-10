<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<form method="post" action="/week2?action=login">
    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" id="email" name="email" required>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
    </div>
    <button type="submit">LOG IN</button>
</form>


<br>
<br>
</body>
</html>