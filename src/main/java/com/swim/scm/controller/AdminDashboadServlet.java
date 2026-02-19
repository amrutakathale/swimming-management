package com.swim.scm.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.swim.scm.DAO.StudentDAO;


@WebServlet("/AdminDashboadServlet")
public class AdminDashboadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentDAO sdao = new StudentDAO();
		int totalStudent = sdao.getStudentCount();
		
		double totalfees =sdao.getTotalFees();
		
		double totalPending =sdao.getTotalPendingFees();
		
		request.setAttribute("totalStudent", totalStudent);
		request.setAttribute("totalfees", totalfees);
		request.setAttribute("totalPending", totalPending);
		RequestDispatcher rd = request.getRequestDispatcher("adminDashboard.jsp");
		    rd.forward(request, response);
	}

}
