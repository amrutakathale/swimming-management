package com.swim.scm.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.swim.scm.DAO.BatchWiseDAO;
import com.swim.scm.model.Student;

@WebServlet("/BatcheWiseReportServlet")
public class BatcheWiseReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batch1 = request.getParameter("batch");
		
		BatchWiseDAO bdao = new BatchWiseDAO();
		
		List<Student>list = bdao.getStudentByBatch(batch1);
	
		request.setAttribute("studentList", list);
	    request.setAttribute("selectedBatch", batch1);

	    request.getRequestDispatcher("batchReport.jsp")
	           .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
