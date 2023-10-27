<%--
  Created by IntelliJ IDEA.
  User: bac
  Date: 24/10/2023
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="cdn.jsp"%>
</head>
<body>
  <%@include file="navbar.jsp"%>
  <div class="container">
      <form action="controls?action=insertStaff" method="post">
          <div class="mb-3">
              <label  class="form-label">Name</label>
              <input type="text" class="form-control" name="name" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
              <label class="form-label">Age</label>
              <input type="text" class="form-control" name="age"  aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
              <label class="form-label">Address</label>
              <input type="text" class="form-control" name="address" aria-describedby="emailHelp">
          </div>
          <div class="mb-3">
              <label  class="form-label">Check-in At</label>
              <input type="date" name="checkin" class="form-control">
          </div>
          <div class="mb-3">
              <label  class="form-label">Manager</label>
              <input type="text" class="form-control" name="manager"  aria-describedby="emailHelp">
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
      </form>

  </div>
<%--buon ngu qua--%>

</body>
</html>
