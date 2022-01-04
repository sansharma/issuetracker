<%--
  Created by IntelliJ IDEA.
  User: sandesh
  Date: 1/1/22
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Manage Role </h1>

<br>
<form action="adduserrole" modelAttribute="addUserRoleData">
<label>Select a User:</label>
<br>
    <select name="username" id="users">
    <c:forEach var="usr" items="${users}">
        <option value=${usr.username}>${usr.username}></option>
    </c:forEach>
    </select>
<br>

<label>Select a Project:</label>
<br>
    <select name="project_name" id="projects">
         <c:forEach var="proj" items= "${projects}">
         <option value=${proj.project_name}>${proj.project_name}></option>
         </c:forEach>
    </select>
<br>
<label>Select a role:</label>

<select name="role" id="role">
    <option value="projectmanager">Project Manager</option>
    <option value="developer">Developer</option>
    <option value="Tester">Tester</option>
</select>
    <br>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
