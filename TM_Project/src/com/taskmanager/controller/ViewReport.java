package com.taskmanager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.TaskManagerDao;
import com.taskmanager.dao.TaskManagerDaoImpl;
import com.taskmanager.models.EmployeeData;

/**
 * Servlet implementation class ViewReport
 */
@WebServlet("/ViewReport")
public class ViewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute("username");
		TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
		String userType = taskManagerDao.getEmployeeType(uname);
		if(userType.equals("HR")) {
			EmployeeData eData = taskManagerDao.getEmployee(uname);
			request.setAttribute("eData", eData);
			request.setAttribute("permition",userType.equals("HR"));
			request.setAttribute("reports", taskManagerDao.getAllReport());
			request.getRequestDispatcher("viewReport.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("index.jsp");
		}
	}

}
