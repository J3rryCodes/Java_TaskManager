package com.taskmanager.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmanager.dao.TaskManagerDao;
import com.taskmanager.dao.TaskManagerDaoImpl;
import com.taskmanager.models.EmployeeData;
import com.taskmanager.models.Replay;

/**
 * Servlet implementation class Notification
 */
@WebServlet("/notifications")
public class Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		if (username != null) {
			TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
			EmployeeData eData = taskManagerDao.getEmployee(username);
			ArrayList<Replay> replay=TaskManagerDaoImpl.getinstance().getReplayByID(eData.getId());
			request.setAttribute("eData", eData);
			request.setAttribute("replays", replay);
			request.getRequestDispatcher("notification.jsp").forward(request, response);;
		}
	}

}
