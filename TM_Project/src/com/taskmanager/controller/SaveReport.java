package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.taskmanager.dao.TaskManagerDaoImpl;

/**
 * Servlet implementation class SaveReport
 */
@WebServlet("/saveReport")
public class SaveReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title= request.getParameter("title");
		String report = request.getParameter("report");
		TaskManagerDaoImpl.getinstance().saveReport(id, title, report);
		response.sendRedirect("home");
	}

}
