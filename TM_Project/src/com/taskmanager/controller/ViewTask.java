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
import com.taskmanager.models.EmployeeTask;

/**
 * Servlet implementation class ViewTask
 */
@WebServlet("/ViewTask")
public class ViewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String) request.getSession().getAttribute("username");
		TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
		EmployeeData eData = taskManagerDao.getEmployee(uname);
		request.setAttribute("eData", eData);
		if(eData.getJob().equals("HR")) {
			ArrayList<EmployeeTask> tasks = taskManagerDao.getAllTaks();
			request.setAttribute("tasks", tasks);
			request.getRequestDispatcher("viewTask.jsp").forward(request, response);
		}
	}

}
