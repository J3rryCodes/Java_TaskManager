package com.taskmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.taskmanager.dao.TaskManagerDao;
import com.taskmanager.dao.TaskManagerDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
		
		String username=request.getParameter("username");
		if (taskManagerDao.checkEmployeeLogin(username, request.getParameter("password"))) {
			
			System.out.println("User " + username + " loging in");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect("home");
			
		} else
			response.sendRedirect("index.jsp");
	}

}
