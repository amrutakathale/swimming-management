package com.swim.scm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.swim.scm.DAO.StudentDAO;
import com.swim.scm.model.Student;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("studentForm.jsp").forward(request, response);	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  Student student = new Student();

		        student.setFullName(request.getParameter("fullName"));
		        student.setAddress(request.getParameter("address"));
		        student.setMobileNo(request.getParameter("mobileNo"));
		        student.setNationality(request.getParameter("nationality"));
		        student.setMaritalStatus(request.getParameter("maritalStatus"));
		        student.setDob(request.getParameter("dob"));
		        student.setAge(Integer.parseInt(request.getParameter("age")));
		        student.setOccupation(request.getParameter("occupation"));
		        student.setBatch(request.getParameter("batch"));
		        student.setAdmissionDate(request.getParameter("admissionDate"));
		        student.setPaymentMode(request.getParameter("paymentMode"));
		        student.setTotalFees(Double.parseDouble(request.getParameter("totalFees")));
		        student.setPaidAmount(Double.parseDouble(request.getParameter("paidAmount")));


		        StudentDAO dao = new StudentDAO();
		        boolean status = dao.saveStudent(student);

		        if (status) {
		            response.sendRedirect("index.jsp");
		        } else {
		            response.getWriter().println("Error Saving Data");
		        }
		    }
	}

