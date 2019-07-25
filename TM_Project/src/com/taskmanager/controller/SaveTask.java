package com.taskmanager.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.taskmanager.dao.TaskManagerDao;
import com.taskmanager.dao.TaskManagerDaoImpl;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;;

/**
 * Servlet implementation class SaveTask
 */
@WebServlet("/saveTask")
public class SaveTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		if (username != null) {
			TaskManagerDao taskManagerDao = TaskManagerDaoImpl.getinstance();
			try {
				List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
						.parseRequest(new ServletRequestContext(request));

				int projectId = Integer.parseInt(items.get(0).getString());
				int employeeId = Integer.parseInt(items.get(1).getString());
				String discription = items.get(2).getString();
				String date = items.get(3).getString();
				String fileName = items.get(4).getName().replaceAll("\\s", "");

				taskManagerDao.saveTask(projectId, employeeId, discription, date, fileName);
				if(fileName != "") {
					String filePath = AppProperties.filePath+ fileName;
					File projectFile = new File(filePath);
					items.get(4).write(projectFile);
				}
				response.sendRedirect("home");
			} catch (Exception e1) {
				e1.printStackTrace();

			}
		} else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
