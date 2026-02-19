<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.swim.scm.model.Student" %> 
<%
Student s = (Student) request.getAttribute("student");
double pending = s.getTotalFees() - s.getPaidAmount();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pay Fees</title>

<style>

    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
    }

    body {
        background: linear-gradient(135deg, #4e73df, #1cc88a);
        padding: 40px;
    }

    .container {
        max-width: 500px;
        background: #fff;
        margin: auto;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 5px 20px rgba(0,0,0,0.2);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .info-box {
        background: #f8f9fc;
        padding: 15px;
        border-radius: 8px;
        margin-bottom: 20px;
    }

    .info-box p {
        margin: 8px 0;
        font-weight: bold;
        color: #444;
    }

    .pending {
        color: #e74a3b;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
        margin-top: 15px;
    }

    input[type="number"] {
        width: 100%;
        padding: 10px;
        border-radius: 6px;
        border: 1px solid #ccc;
        font-size: 15px;
    }

    .btn {
        width: 100%;
        margin-top: 20px;
        padding: 12px;
        background-color: #1cc88a;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s ease;
    }

    .btn:hover {
        background-color: #17a673;
        transform: translateY(-2px);
    }

</style>

</head>
<body>

<div class="container">

    <h2>Pay Student Fees</h2>

    <form action="PayFeesServlet" method="post">

        <input type="hidden" name="id" value="<%= s.getId() %>">

        <div class="info-box">
            <p>Total Fees: ₹ <%= s.getTotalFees() %></p>
            <p>Paid Amount: ₹ <%= s.getPaidAmount() %></p>
            <p class="pending">Pending: ₹ <%= pending %></p>
        </div>

        <label>Enter Payment Amount</label>
        <input type="number" step="0.01" name="payment" required>

        <button type="submit" class="btn">Submit Payment</button>

    </form>

</div>

</body>
</html>
