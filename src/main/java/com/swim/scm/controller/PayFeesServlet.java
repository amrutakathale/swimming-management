package com.swim.scm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.swim.scm.DAO.StudentDAO;
import com.swim.scm.model.Student;


@WebServlet("/PayFeesServlet")
public class PayFeesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO dao = new StudentDAO();
        Student s = dao.getStudentById(id);

        request.setAttribute("student", s);
        request.getRequestDispatcher("payFees.jsp").forward(request, response);
    }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("id"));
            double payment = Double.parseDouble(request.getParameter("payment"));

            StudentDAO dao = new StudentDAO();
            Student s = dao.getStudentById(id);

            double pending = s.getTotalFees() - s.getPaidAmount();

            // ✅ ADD YOUR CHECK HERE
            if (payment > pending) {
                response.getWriter().println("Payment exceeds pending amount!");
                return;
            }

            // ✅ Update Paid Amount
            double newPaid = s.getPaidAmount() + payment;
            s.setPaidAmount(newPaid);

            dao.updateStudent(s);

            response.sendRedirect("ViewAllStudentServlet");
        }
    }


