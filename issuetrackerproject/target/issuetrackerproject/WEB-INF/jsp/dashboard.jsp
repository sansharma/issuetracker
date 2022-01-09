<html>
<head>

    <link rel="stylesheet" type="text/css" href="css/dashboard.css?version=23" />
    <link rel="stylesheet" type="text/css" href="css/popup.css?version=23" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>
    <script src="https://kit.fontawesome.com/4059ae285b.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="navbar">
        <ul>
            <li> <a href="#"  class="active"> <i class="fa fa-light fa-gauge"></i>  Dashboard</a></li>
            <li><a href="/managerolepage?user_id=${user.id}&company_id=${user.company_id}"> <i class="fa fa-solid fa-users"></i>   Manage User Role</a></li>
            <li><a href="/adminprojectpage?user_id=${user.id}&company_id=${user.company_id}"> <i class="fa fa-solid fa-bars-progress"></i>  My Projects</a></li>
            <li><a href="/adminticketpage?user_id=${user.id}&company_id=${user.company_id}"> <i class=" fa fa-solid fa-ticket-simple"></i> My Tickets</a></li>
            <li><a href="/adminprofilepage?user_id=${user.id}&company_id=${user.company_id}"> <i class="fa fa-thin fa-address-card"></i>  My Profile</a></li>
            <li><a href="/adminhelppage?user_id=${user.id}&company_id=${user.company_id}"> <i class="fa fa-solid fa-handshake-angle"></i> Help</a></li>
            <li><a href="/login"><i class="fa fa-solid fa-arrow-right-from-bracket"></i>  Sign Out </a></li>
        </ul>
    </div>

    <div class="table-container">
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
                </tr>
                <tr>
                    <td> 101</td>
                    <td> My Project</td>
                    <td> December 29 2021</td>
                </tr>
                <tr>
                    <td> 101</td>
                    <td> My Project</td>
                    <td> December 29 2021</td>
                </tr>
                <tr>
                    <td> 101</td>
                    <td> My Project</td>
                    <td> December 29 2021</td>
                </tr>
                <tr>
                    <td> 101</td>
                    <td> My Project</td>
                    <td> December 29 2021</td>
                </tr>
                <tr>
                    <td> 101</td>
                    <td> My Project</td>
                    <td> December 29 2021</td>
                </tr>
                <tr>
                    <td> 101</td>
                    <td> My Project</td>
                    <td> December 29 2021</td>
                </tr>
            </table>
        </div>
        </div>
    </div>
</body>
</html>
