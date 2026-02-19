package com.swim.scm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.swim.scm.DAO.StudentDAO;
import com.swim.scm.model.Student;


@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();

        student.setId(Integer.parseInt(request.getParameter("id")));
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
        student.setTotalFees(Double.parseDouble(request.getParameter("totalFees")));
        student.setPaidAmount(Double.parseDouble(request.getParameter("paidAmount")));
        student.setPaymentMode(request.getParameter("paymentMode"));

        StudentDAO dao = new StudentDAO();
        dao.updateStudent(student);

        response.sendRedirect("StudentListServlet");
    }
}
