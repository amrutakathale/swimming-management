package com.swim.scm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import com.swim.scm.DAO.StudentDAO;
import com.swim.scm.model.Student;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private StudentDAO dao;

    @Override
    public void init() {
        dao = new StudentDAO();
    }

    // =========================
    // LOAD STUDENT DATA
    // =========================
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Student student = dao.getStudentById(id);

        request.setAttribute("student", student);

        request.getRequestDispatcher("editStudent.jsp")
               .forward(request, response);
    }

    // =========================
    // UPDATE STUDENT
    // =========================
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
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
        student.setPaymentMode(request.getParameter("paymentMode"));
        student.setTotalFees(Double.parseDouble(request.getParameter("totalFees")));
        student.setPaidAmount(Double.parseDouble(request.getParameter("paidAmount")));

        dao.updateStudent(student);

        response.sendRedirect("student?action=list");
    }
}
