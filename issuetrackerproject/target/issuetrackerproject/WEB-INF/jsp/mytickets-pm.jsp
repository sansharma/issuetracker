<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.issuetracker.Model.TicketModel" %>
<%@ page import="java.net.http.HttpRequest" %>
<%@ page import="com.google.gson.JsonObject" %>
<%@ page import="org.json.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: sandesh
  Date: 1/8/22
  Time: 8:48 AM
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
        <li> <a href="/admindashboard" > <i class="fa fa-light fa-gauge"></i>  Dashboard</a></li>
        <li><a href="/managerolepage"> <i class="fa fa-solid fa-users"></i>   Manage User Role</a></li>
        <li><a href="#"> <i class="fa fa-solid fa-bars-progress"></i>  My Projects</a></li>
        <li><a href="/adminticketpage" class="active"> <i class=" fa fa-solid fa-ticket-simple"></i> My Tickets</a></li>
        <li><a href="/adminprofilepage"> <i class="fa fa-thin fa-address-card"></i>  My Profile</a></li>
        <li><a href="/adminhelppage"> <i class="fa fa-solid fa-handshake-angle"></i> Help</a></li>
        <li><a href="/login"><i class="fa fa-solid fa-arrow-right-from-bracket"></i>  Sign Out </a></li>
    </ul>
</div>


<div class="table-container">
    <div class="table-main-container">
        <a href="#" id="addprojectbutton" onclick="openModal(1)">Create New Ticket </a>
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
                        <td>${ticket.submitted_by   }</td>

                        <td><a href="#" onclick="openPMModal(${ticket.id})"> Update </a></td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>
</div>

<div class="bg-modal" id="bg-modal">
    <div class="addproject-form" >
        <div class="closeBtn" id="closeBtn" >&times;</div>
        <form action="/updateTicket" modelAttribute="updateTicketFormData">
            <h2>Update Ticket:</h2>
            <input type="hidden" name="id" id="id"/>
            <label for="companyname">Ticket Name:</label>
            <br>
            <input type="text" name="ticket_name" id="ticket_name" required/>
            <br>
            <label for="description">Ticket Description:</label>
            <br>
            <input type="text" name="ticket_description" id="ticket_description" required />
            <br>
            <label for="description">Priority</label>
            <br>
            <select id="ticket_priority" name="ticket_priority">
                <option value="high">High</option>
                <option value="medium">Medium</option>
                <option value="low">Low</option>
            </select>
            <br>
            <label for="description">status</label>
            <br>
            <select id="ticket_status" name="status">
                <option value="open">open</option>
                <option value="inprogress">In Progress</option>
                <option value="submitted">Submitted</option>
                <option value="inreview">In Review</option>
                <option value="closed">Closed</option>
            </select>
            <br>
            <label for="description">Assigned To</label>
            <br>
            <select id="assigned_to" name="assigned_to">

            </select>
            <br>
            <input type="hidden" name="project_id" id="project_id" value=${company_id} />
            <input type="hidden" name="submitter_id" id="submitter_id" value=${user_id} />
            <input type="submit" name="adduser" value="Add New User" />
            <br>
        </form>
    </div>
</div>







<script src="/js/commonpm.js?version=26" type="text/javascript"></script>
<script src="/js/validateform.js?version=25" type="text/javascript"></script>
</body>

</html>
