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
 * Servlet implementation class DeleteTask
 */
@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = (String) request.getSession().getAttribute("username");
		if (username != null) {
			TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
			EmployeeData eData = taskManagerDao.getEmployee(username);
			request.setAttribute("eData", eData);

			if (eData.getJob().equals("HR")) {
				taskManagerDao = TaskManagerDaoImpl.getinstance();
				taskManagerDao.deleteTask(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect("ViewTask");
			}
		}
	}
}
