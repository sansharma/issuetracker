<%--
  Created by IntelliJ IDEA.
  User: sandesh
  Date: 12/31/21
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Register User</h1>
<form action="registeruser" modelAttribute="registerFormData">
    <label>CompanyName</label>
    <input type = "text" name="company_name"/>
    <br>
    <label>Username</label>
    <input type = "text" name="username"/>
    <br>
    <Label>Password</Label>
    <input type = "password" name="password"/>
    <br>
    <Label>Email</Label>
    <input type = "email" name="email"/>
    <br>
    <input type="submit" name="submit"/>
</form>

</body>
</html>
