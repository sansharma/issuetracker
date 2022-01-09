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

    <link rel="stylesheet" type="text/css" href="css/dashboard.css?version=27" />
    <link rel="stylesheet" type="text/css" href="css/popup.css?version=31" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/4059ae285b.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<body>
<div class="navbar">
    <ul>
        <li> <a href="/admindashboard?user_id=${user_id}&company_id=${company_id}" > <i class="fa fa-light fa-gauge"></i>  Dashboard</a></li>
        <li><a href="/managerolepage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-users"></i>   Manage User Role</a></li>
        <li><a href="/adminprojectpage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-bars-progress"></i>  My Projects</a></li>
        <li><a href="/adminticketpage?user_id=${user_id}&company_id=${company_id}" class="active"> <i class=" fa fa-solid fa-ticket-simple"></i> My Tickets</a></li>
        <li><a href="/adminprofilepage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-thin fa-address-card"></i>  My Profile</a></li>
        <li><a href="/adminhelppage?user_id=${user_id}&company_id=${company_id}"> <i class="fa fa-solid fa-handshake-angle"></i> Help</a></li>
        <li><a href="/login"><i class="fa fa-solid fa-arrow-right-from-bracket"></i>  Sign Out </a></li>
    </ul>
</div>


<div class="table-container">
    <c:forEach var="prj" items="${projects}">
        <h3 style="margin-left: 200px; line-height:20%">Project id :${prj.id}</h3>
        <h3 style="margin-left: 200px; line-height:20%"> Project Name: ${prj.project_name}</h3>
        <h3 style="margin-left: 200px; line-height:20%"> Project Start Date: ${prj.start_date}</h3>
    </c:forEach>

    <a href="#" id="addprojectbutton" onclick="openModal(4)">Create New Ticket </a>
    <br>
    <br>
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
        <form action="/addticket" modelAttribute="addTicketData">
            <h2>Create a New Ticket</h2>
            <label for="companyname">Ticket Name</label>
            <br>
            <input type="text" name="ticket_name" required/>
            <br>
            <label for="description">Ticket Description:</label>
            <br>
            <input type="text" name="ticket_description" id="ticket_description" required />
            <br>
            <label for="description">Ticket Priority:</label>
            <br>
            <select id="ticket_priority" name="ticket_priority">
                <option value="low">low</option>
                <option value="medium">medium</option>
                <option value="high">high</option>
            </select>
            <br>
            <label for="description">Ticket Status:</label>
            <br>
            <select id="status" name="status">
                <option value="open">Open</option>
            </select>
            <br>
            <label for="description">Select Project:</label>
            <br>
            <select id="project_id" name="project_id">

            </select>
            <br>
            <input type="hidden" name="company_id" id="company_id" value=${company_id} />
            <input type="hidden" name="submitter_id" id="submitter_id" value=${user_id} />
            <input type="submit" name="createticket" value="Create Ticket" />
            <br>
        </form>
    </div>
</div>


<script src="/js/validateform.js?version=25" type="text/javascript"></script>
<script src="/js/common.js?version=13" type="text/javascript"></script>
</body>

</html>
