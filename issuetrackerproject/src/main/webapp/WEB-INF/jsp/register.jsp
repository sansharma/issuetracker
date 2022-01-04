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
    <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>


<div class="register-form">
    <form>
        <h2>Issue Tracker Signup</i></h2>
        <label for="companyname">Company Name</label>
        <br>
        <input type="text" name="companyname"/>
        <br>
        <label for="username">Username</label>
        <br>
        <input type="text" name="username"/>
        <br>
        <label for="email">Email</label>
        <br>
        <input type="text" name="email"/>
        <br>
        <label for="password">Password</label>
        <br>
        <input type="password" name="password"/>
        <br>
        <label for="password">Confirm Password</label>
        <br>
        <input type="password" name="confirm_password"/>
        <br>
        <input type="submit" name="Signup" value="signup"/>
        <br>
    </form>

</div>
<%--<form action="login" modelAttribute="userFormData">--%>
<%--    <label>Username</label>--%>
<%--    <input type = "text" name="username"/>--%>
<%--    <br>--%>
<%--    <Label>Password</Label>--%>
<%--    <input type = "password" name="password"/>--%>
<%--    <br>--%>
<%--    <input type="submit" name="submit"/>--%>
<%--</form>--%>
<%--<form action="signup">--%>
<%--    <input type="submit" name="submit"/>--%>
<%--</form>--%>

</body>
</html>
