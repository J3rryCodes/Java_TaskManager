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

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String tel = request.getParameter("number");
		String dateOfJoin = request.getParameter("dateofjoin");
		int languageId = Integer.parseInt(request.getParameter("jobspc"));
		String pass = request.getParameter("pass");
		
		TaskManagerDao taskManagerDao=TaskManagerDaoImpl.getinstance();
		
		/*
		 * System.out.println(username); System.out.println(email);
		 * System.out.println(tel); System.out.println(dateOfJoin);
		 * System.out.println(jobSpc); System.out.println(pass);
		 */
		taskManagerDao.registerEmployeeData(username, email, tel, dateOfJoin, languageId, pass);
		
		response.getWriter().println("<label>Registration Completed</label>");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

}
