<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>

<style>
    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
    }

    body {
        background: linear-gradient(135deg, #4e73df, #1cc88a);
        padding: 20px;
    }

    .container {
        max-width: 600px;
        background: #ffffff;
        padding: 25px;
        margin: auto;
        border-radius: 10px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.2);
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
        color: #444;
    }

    input, select, textarea {
        width: 100%;
        padding: 8px;
        border-radius: 5px;
        border: 1px solid #ccc;
        font-size: 14px;
    }

    .radio-group {
        display: flex;
        gap: 15px;
        margin-top: 5px;
    }

    .radio-group input {
        width: auto;
    }

    .btn {
        width: 100%;
        padding: 10px;
        background: #4e73df;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        background: #2e59d9;
    }

    /* Mobile Responsive */
    @media (max-width: 600px) {
        .container {
            padding: 15px;
        }

        h2 {
            font-size: 20px;
        }

        input, select, textarea {
            font-size: 13px;
        }
    }
    
    a{
    font-size: 20px;
    font-weight: bold;
    background: #4e73df;
    }
</style>

</head>
<body>
<a href="${pageContext.request.contextPath }/AdminDashboadServlet">Back</a><br>

<div class="container">

    <h2>Membership Application</h2>

    <form action="AddStudentServlet" method="post">

        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="fullName" required>
        </div>

        <div class="form-group">
            <label>Address</label>
            <textarea name="address" rows="3" required></textarea>
        </div>

        <div class="form-group">
            <label>Mobile No</label>
            <input type="tel" name="mobileNo" pattern="[0-9]{10}" required>
        </div>

        <div class="form-group">
            <label>Nationality</label>
            <input type="text" name="nationality" required>
        </div>

        <div class="form-group">
            <label>Marital Status</label>
            <div class="radio-group">
                <label><input type="radio" name="maritalStatus" value="Married" required> Married</label>
                <label><input type="radio" name="maritalStatus" value="Single"> Single</label>
            </div>
        </div>

        <div class="form-group">
            <label>Date of Birth</label>
            <input type="date" name="dob" required>
        </div>

        <div class="form-group">
            <label>Age</label>
            <input type="number" name="age" min="1" required>
        </div>

        <div class="form-group">
            <label>Occupation</label>
            <input type="text" name="occupation">
        </div>

        <div class="form-group">
            <label>Batch</label>
            <select name="batch" required>
                <option value="">Select Batch</option>
                <option>Morning</option>
                <option>Afternoon</option>
                <option>Evening</option>
            </select>
        </div>

        <div class="form-group">
            <label>Admission Date</label>
            <input type="date" name="admissionDate" required>
        </div>
        
        <div class="form-group">
		    <label>Total Fees</label>
		    <input type="number" step="0.01" name="totalFees" required>
		</div>
		
		<div class="form-group">
		    <label>Paid Amount</label>
		    <input type="number" step="0.01" name="paidAmount" required>
		</div>

        <div class="form-group">
            <label>Payment Mode</label>
            <div class="radio-group">
                <label><input type="radio" name="paymentMode" value="Cash" required> Cash</label>
                <label><input type="radio" name="paymentMode" value="Online"> Online</label>
            </div>
        </div>

        <button type="submit" class="btn">Submit</button>

    </form>
</div>

</body>
</html>
