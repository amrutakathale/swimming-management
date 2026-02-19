<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<style>
body {
    background-color: #f8f9fa;
}
.sidebar {
    height: 100vh;
    background: #343a40;
    color: white;
    padding-top: 20px;
}
.sidebar a {
    color: white;
    text-decoration: none;
    display: block;
    padding: 12px;
}
.sidebar a:hover {
    background: #495057;
}
.content {
    padding: 20px;
}
</style>
</head>

<body>

<div class="container-fluid">
<div class="row">

<!-- LEFT SIDEBAR MENU -->
<div class="col-md-2 sidebar">
    <h4 class="text-center">Admin Panel</h4>
    <hr>

    <a href="${pageContext.request.contextPath }/AdminDashboadServlet">🏠 Dashboard</a>
    <a href="AddStudentServlet">➕ Add Student</a>
 	<a href="ViewAllStudentServlet">👥 View All Student</a>
    <a href="attendance.jsp">📅 Attendance</a>
    <a href="BatcheWiseReportServlet">💰 Batchewise Report </a>
    <a href="reports.jsp">📊 Fees </a>
    
</div>

<!-- MAIN CONTENT AREA -->
<div class="col-md-10 content">

    <h2>Welcome, Admin</h2>
    <p>Student Management System Dashboard</p>
    

    <div class="row">

        <!-- Total Employees -->
        <div class="col-md-3">
            <div class="card text-white bg-primary mb-3">
                <div class="card-body">
                    <h5 class="card-title">Total Students</h5>
                    <h2>${totalStudent}</h2>

                </div>
            </div>
        </div>
        
        <div class="col-md-3">
            <div class="card text-white bg-success mb-3">
                <div class="card-body">
                    <h5 class="card-title">Tottal Fees </h5>
                    <h3>${totalfees }</h3>
                </div>
            </div>
        </div>
    
		<div class="col-md-3">
		    <div class="card bg-danger text-white p-3">
		        <h5>Total Pending Fees</h5>
		        <h2>${totalPending}</h2>
		    </div>
		</div>


    </div>

</div>
</div>
</div>

</body>
</html>
