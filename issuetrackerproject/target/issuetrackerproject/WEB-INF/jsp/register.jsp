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
    <link rel="stylesheet" type="text/css" href="css/register.css?version=26">
    <script src="js/validateform.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<div class="register-form" >
    <form action="registeruser" modelAttribute="registerFormData" onsubmit="validateRegistrationForm()">
        <h2>Issue Tracker Signup</h2>
        <label for="companyname">Company Name</label>
        <br>
        <input type="text" name="company_name" required/>
        <br>
        <label for="username">Username</label>
        <br>
        <input type="text" name="username" id="username" required  onkeyup="checkUserExist()"/>
        <br>
        <p id="checkuserlabel" style="display: none">Username already exists!</p>
        <p id="checkspacelabel" style="display: none">Space is not allowed in Username</p>
        <label for="email">Email</label>
        <br>
        <input type="text" name="email" required/>
        <br>
        <label for="password">Password</label>
        <br>
        <input type="password" name="password" id="password" required/>
        <br>
        <label for="password">Confirm Password</label>
        <br>
        <input type="password" name="confirm_password" id="confirm_password" required/>
        <br>
        <p id="passwordmismatch" style="display: none">Confirm Password and Password must match!</p>
        <input type="submit" name="Signup" value="signup" onclick="return validateRegistrationForm()"/>
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
