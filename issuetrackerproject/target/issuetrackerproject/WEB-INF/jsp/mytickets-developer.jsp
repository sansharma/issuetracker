<%--
  Created by IntelliJ IDEA.
  User: sandesh
  Date: 1/8/22
  Time: 8:07 AM
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
            <td>${ticket.submitter_id}</td>

            <td><a href="#" onclick="openDeveloperModal(${ticket.id}, '${ticket.status}')"> Details </a></td>
          </tr>
        </c:forEach>

      </table>

    </div>
  </div>
</div>

<div class="bg-modal" id="bg-modal">
  <div class="addproject-form" >
    <div class="closeBtn" id="closeBtn" >&times;</div>
    <form action="/updateDeveloperTicket" modelAttribute="addTicketStatusData">
      <h2>Change Ticket Status</h2>
      <br>
      <label for="description">Ticket Status:</label>
      <br>
      <select id="ticket_status" name="status">
        <option value="open">OPEN</option>
        <option value="inprogress">IN PROGRESS</option>
        <option value="submitted">SUBMITTED</option>
      </select>
      <br>
      <input type="hidden" name="id" id="ticket_id"/>
      <input type="hidden" name="project_id" id="company_id" value=${company_id} />
      <input type="hidden" name="submitter_id" id="submitter_id" value=${user_id} />
      <input type="submit" name="createticket" value="Create Ticket" />
      <br>
    </form>
  </div>
</div>




<script src="/js/commondeveloper.js?version=25" type="text/javascript"></script>
<script src="/js/validateform.js?version=25" type="text/javascript"></script>
</body>

</html>
