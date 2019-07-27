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
 * Servlet implementation class SeenNotificaation
 */
@WebServlet("/seenNotificaation")
public class SeenNotificaation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute("username");
		TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
		if (uname != null) {
			taskManagerDao.seenNotification(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("notifications");
		}
		else
			response.sendRedirect("index.jsp");
	}

}
