package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.TaskManagerDaoImpl;
import com.taskmanager.models.EmployeeData;

/**
 * Servlet implementation class AddReport
 */
@WebServlet("/AddReport")
public class AddReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username =(String) request.getSession().getAttribute("username");
		EmployeeData eData = TaskManagerDaoImpl.getinstance().getEmployee(username);
		request.setAttribute("eData", eData);
		request.getRequestDispatcher("addReport.jsp").forward(request, response);
	}
}
