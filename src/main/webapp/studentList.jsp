<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.swim.scm.model.Student" %>

<html>
<head>
<title>Student List</title>
<style>
   .action-buttons {
    display: flex;
    gap: 10px;
	}
	
	.btn {
	    padding: 6px 14px;
	    text-decoration: none;
	    color: white;
	    border-radius: 5px;
	    font-size: 14px;
	    font-weight: bold;
	    transition: all 0.3s ease;
	}
	
	/* Edit Button */
	.edit-btn {
	    background-color: #4e73df;
	}
	
	.edit-btn:hover {
	    background-color: #2e59d9;
	    transform: translateY(-2px);
	}
	
	/* Pay Fees Button */
	.pay-btn {
	    background-color: #1cc88a;
	}
	
	.pay-btn:hover {
	    background-color: #17a673;
	    transform: translateY(-2px);
	}
	
	/* Delete Button */
	.delete-btn {
	    background-color: #e74a3b;
	}
	
	.delete-btn:hover {
	    background-color: #c0392b;
	    transform: translateY(-2px);
	}

    
</style>
</head>
<body>

<h2>Student List</h2>
<a href="${pageContext.request.contextPath }/AdminDashboadServlet">Back</a><br><br>
<a href="${pageContext.request.contextPath }/AddStudentServlet">Add New Student</a><br>
<br><br>

<table border="1" cellpadding="10">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Mobile</th>
    <th>Batch</th>
    <th>Payment</th>
    <th>Total Fees</th>
	<th>Paid</th>
	<th>Pending</th>
    
    <th>Action</th>
</tr>

<%
List<Student> list = (List<Student>) request.getAttribute("student");

for (Student s : list) {
%>

<tr>
    <td><%= s.getId() %></td>
    <td><%= s.getFullName() %></td>
    <td><%= s.getMobileNo() %></td>
    <td><%= s.getBatch() %></td>
    <td><%= s.getPaymentMode() %></td>
    <td><%= s.getTotalFees() %></td>
	<td><%= s.getPaidAmount() %></td>
	<td style="color:red;">
	    <%= s.getPendingFees() %>
	</td>
    
   <td class="action-buttons">
	    <a href="EditStudentServlet?id=<%= s.getId() %>" class="btn edit-btn">Edit</a>
	    
	    <a href="PayFeesServlet?id=<%= s.getId() %>" class="btn pay-btn">Pay Fees</a>	    
	    
	    <a href="DeleteStudentServlet?id=<%= s.getId() %>"
	       onclick="return confirm('Are you sure?')"
	       class="btn delete-btn">Delete</a>
	</td>
</tr>

<% } %>


</table>

</body>
</html>
