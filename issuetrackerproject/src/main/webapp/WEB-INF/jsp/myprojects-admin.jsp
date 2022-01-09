<%--
  Created by IntelliJ IDEA.
  User: sandesh
  Date: 1/4/22
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="css/dashboard.css?version=14" />
    <link rel="stylesheet" type="text/css" href="css/popup.css?version=21" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/4059ae285b.js" crossorigin="anonymous"></script>


</head>
<body>
<div class="navbar">
    <ul>
        <li> <a href="/admindashboard?user_id=${user_id}&company_id=${company_id}" > <i class="fa fa-light fa-gauge"></i>  Dashboard</a></li>
        <li><a href="/managerolepage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-users"></i>   Manage User Role</a></li>
        <li><a href="/adminprojectpage?user_id=${user_id}&company_id=${company_id}" class="active"> <i class="fa fa-solid fa-bars-progress"></i>  My Projects</a></li>
        <li><a href="/adminticketpage?user_id=${user_id}&company_id=${company_id}"> <i class=" fa fa-solid fa-ticket-simple"></i> My Tickets</a></li>
        <li><a href="/adminprofilepage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-thin fa-address-card"></i>  My Profile</a></li>
        <li><a href="/adminhelppage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-handshake-angle"></i> Help</a></li>
        <li><a href="/login"><i class="fa fa-solid fa-arrow-right-from-bracket"></i>  Sign Out </a></li>
    </ul>
</div>


<div class="table-container">
    <a href="#" id="addprojectbutton" onclick="openModal(3)">Add New Project </a>
    <br>
    <br>
    <div class="table-main-container">
    <div class="table-description">
        <h3>My Projects</h3>
        <h4> All the Projects that you have created</h4>
    </div>
    <div class="project-table">
        <table>
            <tr>
                <th>Project Id</th>
                <th> Project Name</th>
                <th>start_date</th>
                <th>Action</th>
            </tr>
            <c:forEach var="prj" items="${projects}">
                <tr>
                    <td>${prj.id}</td>
                    <td>${prj.project_name}</td>
                    <td>${prj.start_date}</td>
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
            <form action="/addproject" modelAttribute="addProjectData">
                <h2>Add Project</h2>
                <label for="companyname">Project Name</label>
                <br>
                <input type="text" name="project_name" required/>
                <br>
                <label for="startdate">Start Date:</label>
                <br>
                <input type="text" name="start_date" id="startdate" required />
                <br>
                <input type="hidden" name="company_id" value=${company_id} />
                <input type="submit" name="Signup" value="signup" />
                <br>
            </form>
        </div>
    </div>


<script src="/js/validateform.js" type="text/javascript"></script>
<script src="/js/common.js?version=13" type="text/javascript"></script>
</body>

</html>
