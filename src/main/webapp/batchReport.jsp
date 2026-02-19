<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.swim.scm.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>batchwise</title>
<style>
<style>

body {
    font-family: Arial, Helvetica, sans-serif;
    background: #f8f9fc;
    margin: 0;
    padding: 20px;
}

/* Container spacing */
form {
    margin-bottom: 20px;
}

/* Headings */
h3 {
    color: #4e73df;
    margin-bottom: 15px;
}

h4 {
    margin-top: 25px;
    color: #333;
}

/* Buttons */
button {
    padding: 10px 18px;
    margin: 6px 5px;
    background: linear-gradient(45deg, #4e73df, #224abe);
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
    font-size: 14px;
    transition: 0.3s ease;
}

button:hover {
    background: linear-gradient(45deg, #2e59d9, #1b3f99);
}

/* Table */
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
    background: white;
    box-shadow: 0 4px 12px rgba(0,0,0,0.08);
}

th, td {
    padding: 12px;
    text-align: center;
}

th {
    background: #4e73df;
    color: white;
}

tr:nth-child(even) {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #e2e6f5;
}

/* Back Button */
a {
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    padding: 8px 15px;
    background: #858796;
    color: white;
    border-radius: 5px;
}

a:hover {
    background: #60616f;
}

/* ========================= */
/* MOBILE RESPONSIVE DESIGN */
/* ========================= */

@media screen and (max-width: 768px) {

    body {
        padding: 10px;
    }

    /* Buttons full width */
    button {
        width: 100%;
        margin: 6px 0;
    }

    /* Convert table to card layout */
    table, thead, tbody, th, td, tr {
        display: block;
        width: 100%;
    }

    thead {
        display: none;
    }

    tr {
        margin-bottom: 15px;
        background: white;
        padding: 10px;
        border-radius: 8px;
        box-shadow: 0 3px 8px rgba(0,0,0,0.08);
    }

    td {
        text-align: left;
        padding: 8px 10px;
        position: relative;
        padding-left: 50%;
    }

    td::before {
        position: absolute;
        left: 10px;
        top: 8px;
        width: 45%;
        font-weight: bold;
        white-space: nowrap;
    }

    td:nth-of-type(1)::before { content: "ID"; }
    td:nth-of-type(2)::before { content: "Name"; }
    td:nth-of-type(3)::before { content: "Mobile"; }
    td:nth-of-type(4)::before { content: "Batch"; }
    td:nth-of-type(5)::before { content: "Total Fees"; }
    td:nth-of-type(6)::before { content: "Paid"; }
    td:nth-of-type(7)::before { content: "Pending"; color: red; }

}

</style>


</style>
</head>
<body>

<form action="BatcheWiseReportServlet" method="get">	
	<h3>Btchewise Report</h3>
	
	<button type="submit" name="batch" value="Morning">Morning</button>
	<button type="submit" name="batch" value="Afternoon">Afternoon</button>
	<button type="submit" name="batch" value="Evening">Evening</button>
	
</form>
	

<%
List<Student> list = (List<Student>) request.getAttribute("studentList");

if (list != null && !list.isEmpty()) {
%>

<h4>Batch Students</h4>

<table border="1" cellpadding="8">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Mobile</th>
    <th>Batch</th>
    <th>Total Fees</th>
    <th>Paid</th>
    <th>Pending</th>
</tr>

<%
for (Student s : list) {
%>
<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getFullName() %></td>
    <td><%= s.getMobileNo() %></td>
    <td><%= s.getBatch() %></td>    
    <td><%= s.getTotalFees() %></td>
    <td><%= s.getPaidAmount() %></td>
    <td style="color:red;">
        <%= s.getTotalFees() - s.getPaidAmount() %>
    </td>
</tr>
<% } %>

</table>

<% } %>

<a href="${pageContext.request.contextPath }/AdminDashboadServlet">Back</a><br><br>


</body>
</html>