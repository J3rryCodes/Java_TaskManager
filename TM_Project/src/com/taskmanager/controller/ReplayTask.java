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
 * Servlet implementation class ReplayTask
 */
@WebServlet("/ReplayTask")
public class ReplayTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		if (username != null) {
			TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
			EmployeeData eData = taskManagerDao.getEmployee(username);
			request.setAttribute("eData", eData);
			if (eData.getJob().equals("HR")) {
				int taskId=Integer.parseInt(request.getParameter("id"));
				String replay = request.getParameter("replay");
				taskManagerDao.addReplay(taskId, replay);
				response.sendRedirect("ViewReport");
			}
		}
	}
}
