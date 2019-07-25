package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.TaskManagerDao;
import com.taskmanager.dao.TaskManagerDaoImpl;
import com.taskmanager.models.EmployeeData;

/**
 * Servlet implementation class AddProject
 */
@WebServlet("/addProject")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		if (username != null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("addProject.jsp");
			TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
			EmployeeData eData = taskManagerDao.getEmployee(username);
			request.setAttribute("eData", eData);
			if (eData.getJob().equals("HR")) {
				request.setAttribute("languages", taskManagerDao.getLanguages());
				requestDispatcher.forward(request, response);
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
