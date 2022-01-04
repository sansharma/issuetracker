<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>

<div class="site-description">
    <h1><i>Issue Tracker</i></h1>
    <p> An application to track Issues in your code. </p>
    <p>Report the issue to the project Manager</p>
    <p> Project Manager assigns the developer to resolve the issue.</p>
    <p> Developer Resolves the issue and submits to the project manager.</p>
    <p> Project Manager reviews and your issue gets resolved.</p>

</div>

<div class="login-form">
<form>
    <h3>Login/SignUp</h3>
    <label for="username">Username</label>
    <br>
    <input type="text" name="username"/>
    <br>
    <label for="password">Password</label>
    <br>
    <input type="password" name="password"/>
    <br>
    <input type="submit" name="Login" value="Login"/>
    <br>
    <a href="#">Forget Password?</a>
    <br>
    <br>
    <label> Don't have an account?</label>
    <br>
    <input type="submit" name="Signup" value="Signup" id="signup"/>

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
