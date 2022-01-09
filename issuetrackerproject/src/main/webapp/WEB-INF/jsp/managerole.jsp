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

    <link rel="stylesheet" type="text/css" href="css/dashboard.css?version=15" />
    <link rel="stylesheet" type="text/css" href="css/popup.css?version=8" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/4059ae285b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<div class="navbar">
    <ul>
        <li> <a href="/admindashboard?user_id=${user_id}&company_id=${company_id}" > <i class="fa fa-light fa-gauge"></i>  Dashboard</a></li>
        <li><a href="/managerolepage?user_id=${user_id}&company_id=${company_id}" class="active"> <i class="fa fa-solid fa-users"></i>   Manage User Role</a></li>
        <li><a href="/adminprojectpage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-bars-progress"></i>  My Projects</a></li>
        <li><a href="/adminticketpage?user_id=${user_id}&company_id=${company_id}"> <i class=" fa fa-solid fa-ticket-simple"></i> My Tickets</a></li>
        <li><a href="/adminprofilepage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-thin fa-address-card"></i>  My Profile</a></li>
        <li><a href="/adminhelppage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-handshake-angle"></i> Help</a></li>
        <li><a href="/login"><i class="fa fa-solid fa-arrow-right-from-bracket"></i>  Sign Out </a></li>
    </ul>
</div>

<div class="table-container">
    <a href="#" id="adduserbutton" onclick="openModal(1)">Add New User </a>
    <a href="#" id="addrolebutton" onclick="openModal(2)">Add New Role</a>
    <br>
    <br>
    <br>
    <div class="table-main-container">
    <div class="table-description">
        <h3>Roles</h3>
        <h4> All the roles in the system.</h4>
    </div>
    <div class="project-table">
        <table>
            <tr>
                <th>User Name</th>
                <th>Role</th>
                <th>Details</th>
            </tr>
            <c:forEach var="role" items="${roles}">
                <tr>
                    <td>${role.username}</td>
                    <td>${role.role}</td>
                    <td><a href="/projectdetails?id=${prj.id}&company_id=${prj.company_id}"> Details </a></td>
                </tr>
            </c:forEach>

        </table>

    </div>
    </div>
</div>


<div class="bg-modal" id="bg-modal">
    <div class="addproject-form" >
        <div class="closeBtn" id="closeBtn" >&times;</div>
        <form action="/adduser" modelAttribute="addUserFromData">
            <h2>Add New User</h2>
            <label for="companyname">UserName</label>
            <br>
            <input type="text" name="username" required/>
            <br>
            <label for="description">password</label>
            <br>
            <input type="password" name="password" id="password" required />
            <br>
            <label for="description">email</label>
            <br>
            <input type="email" name="email" id="email"/>
            <br>
            <label for="description">role</label>
            <br>
            <select id="role" name="role">
                <option value="admin">Admin</option>
                <option value="projectmanager">Project Manager</option>
                <option value="developer">Developer</option>
                <option value="tester">Tester</option>
            </select>
            <br>
            <input type="hidden" name="company_id" id="company_id" value=${company_id} />
            <input type="hidden" name="submitter_id" id="submitter_id" value=${user_id} />
            <input type="submit" name="adduser" value="Add New User" />
            <br>
        </form>
    </div>
</div>



<div class="bg-modal-1" id="bg-modal-1">
    <div class="addproject-form" >
        <div class="closeBtn1" id="closeBtn1" >&times;</div>
        <form action="/adduserrole" modelAttribute="addUserRoleData">
            <h2>Add New Role</h2>
            <label for="companyname">User Name</label>
            <br>
            <select id="user_id" name="user_id">

            </select>
            <br>
            <br>
            <label for="description">Role:</label>
            <br>
            <select id="role1" name="role">
                <option value="project_manager" name="project_manager">Project Manager</option>
                <option value="developer" name="developer">Developer</option>
                <option value="tester" name="tester">Tester</option>
            </select>
            <br>
            <input type="hidden" name="company_id" id="c_id" value=${company_id} />
            <input type="submit" name="addrole" value="Add new Role" />
            <br>
        </form>
    </div>
</div>
<script src="/js/validateform.js?version=13" type="text/javascript"></script>
<script src="/js/common.js?version=13" type="text/javascript"></script>
</body>
</html>








<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1> Manage Role </h1>--%>

<%--<br>--%>
<%--<form action="adduserrole" modelAttribute="addUserRoleData">--%>
<%--<label>Select a User:</label>--%>
<%--<br>--%>
<%--    <select name="username" id="users">--%>
<%--    <c:forEach var="usr" items="${users}">--%>
<%--        <option value=${usr.username}>${usr.username}></option>--%>
<%--    </c:forEach>--%>
<%--    </select>--%>
<%--<br>--%>

<%--<label>Select a Project:</label>--%>
<%--<br>--%>
<%--    <select name="project_name" id="projects">--%>
<%--         <c:forEach var="proj" items= "${projects}">--%>
<%--         <option value=${proj.project_name}>${proj.project_name}></option>--%>
<%--         </c:forEach>--%>
<%--    </select>--%>
<%--<br>--%>
<%--<label>Select a role:</label>--%>

<%--<select name="role" id="role">--%>
<%--    <option value="projectmanager">Project Manager</option>--%>
<%--    <option value="developer">Developer</option>--%>
<%--    <option value="Tester">Tester</option>--%>
<%--</select>--%>
<%--    <br>--%>
<%--    <input type="submit" value="submit"/>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
