<%--
  Created by IntelliJ IDEA.
  User: sandesh
  Date: 1/5/22
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%><%--
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

    <link rel="stylesheet" type="text/css" href="css/dashboard.css?version=39" />
    <link rel="stylesheet" type="text/css" href="css/popup.css?version=26" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/4059ae285b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<body>
<div class="navbar">
    <ul>
        <li> <a href="/admindashboard" > <i class="fa fa-light fa-gauge"></i>  Dashboard</a></li>
        <li><a href="/managerolepage"> <i class="fa fa-solid fa-users"></i>   Manage User Role</a></li>
        <li><a href="#" class="active"> <i class="fa fa-solid fa-bars-progress"></i>  My Projects</a></li>
        <li><a href="/adminticketpage"> <i class=" fa fa-solid fa-ticket-simple"></i> My Tickets</a></li>
        <li><a href="/adminprofilepage"> <i class="fa fa-thin fa-address-card"></i>  My Profile</a></li>
        <li><a href="/adminhelppage"> <i class="fa fa-solid fa-handshake-angle"></i> Help</a></li>
        <li><a href="/login"><i class="fa fa-solid fa-arrow-right-from-bracket"></i>  Sign Out </a></li>
    </ul>
</div>


<div class="table-container">
        <h3 style="margin-left: 200px; line-height:20%">Project id :${project.id}</h3>
        <h3 style="margin-left: 200px; line-height:20%"> Project Name: ${project.project_name}</h3>
        <h3 style="margin-left: 200px; line-height:20%"> Project Start Date: ${project.start_date}</h3>
    <a href="#" id="adduserprojectbutton" onclick="openModal(5)" >Add New User to this Project </a>
    <div class="table-main-container">
        <div class="table-description">
            <h3>Tickets</h3>
            <h4> All the Tickets for this project</h4>
        </div>
        <div class="project-table">
            <table>
                <tr>
                    <th>Ticket Id</th>
                    <th> Ticket Name</th>
                    <th>Ticket Description</th>
                    <th>Ticket Priority</th>
                    <th> Status</th>
                    <th> Assigned To </th>
                    <th>Submitted By</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="ticket" items="${tickets}">
                    <tr>
                        <td>${ticket.id}</td>
                        <td>${ticket.ticket_name}</td>
                        <td>${ticket.ticket_description}</td>
                        <td>${ticket.ticket_priority}</td>
                        <td>${ticket.status}</td>
                        <td>${ticket.assigned_to}</td>
                        <td>${ticket.submitter_id}</td>

                        <td><a href="/projectdetails?id=${project.id}&company_id=${project.company_id}"> Details </a></td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>


    <div class="table-main-container">
        <div class="table-description">
            <h3>Users</h3>
            <h4> All the users for this project</h4>
        </div>
        <div class="project-table">
            <table>
                <tr>
                    <th>UserName</th>
                    <th>Role</th>
                </tr>
                <c:forEach var="role" items="${roles}">
                    <tr>
                        <td>${role.username}</td>
                        <td>${role.role}</td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>



</div>





<div class="bg-modal" id="bg-modal">
    <div class="addproject-form"     >
        <div class="closeBtn" id="closeBtn" >&times;</div>
        <form action="/addusertoproject" modelAttribute="addUserProjectData">
            <h2>Select user to add:</h2>
            <select id="user_id" name="user_id">

            </select>
            <input type="hidden" name="project_id" value=${project.id} />
            <input type="hidden" value=${company_id} name="company_id" id="company_id"/>
            <input type="submit" name="adduserrole" value="Add User to Project" />
        </form>
    </div>
</div>


<script src="/js/validateform.js?version=16" type="text/javascript"></script>
<script src="/js/common.js?version=12" type="text/javascript"></script>
</body>

</html>
