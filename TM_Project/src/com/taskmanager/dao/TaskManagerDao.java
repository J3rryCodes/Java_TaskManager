package com.taskmanager.dao;

import java.util.ArrayList;

import com.taskmanager.models.EmployeeData;
import com.taskmanager.models.EmployeeTask;
import com.taskmanager.models.Languages;
import com.taskmanager.models.Projects;
import com.taskmanager.models.Replay;
import com.taskmanager.models.Report;

public interface TaskManagerDao {
	//checkEmployeeLogin
	public boolean checkEmployeeLogin(String username,String password);
	//registerEmployeeData
	public void  registerEmployeeData(String username,String email,String number,String dateOfJoin,int jobSpc,String password);
	//getEmployeeType
	public String getEmployeeType(String username);
	//getTaks
	public ArrayList<EmployeeTask> getTaks(int id);
	//getAllProjects
	public ArrayList<Projects> getAllProjects();
	//getAllTaks
	public ArrayList<EmployeeTask> getAllTaksByProjectID();
	//getEmployee
	public EmployeeData getEmployee(String username);
	//getLanguages
	public ArrayList<Languages> getLanguages();
	//saveProject
	public void saveProject(String pname, int id, String discription, String deadLine) ;
	//getProjectById
	public Projects getProjectById(int id);
	//getEmployeeByLanguageId
	public ArrayList<EmployeeData> getEmployeeByLanguageId(int languageID);
	//saveTask
	public void saveTask(int projectId, int employeeId, String discription, String date, String filePath);
	//saveReport
	public void saveReport(int employeeId,String title,String report);
	//getAllReport
	public ArrayList<Report> getAllReport();
	//submitTask
	public void submitTask(int id);
	//deleteProject
	public void deleteProject(int id);
	//getAllTaks
	public ArrayList<EmployeeTask> getAllTaks();
	//deleteTask
	public void deleteTask(int id);
	//addReplay
	public void addReplay(int id,String replay);
	//getReplayByID
	public ArrayList<Replay> getReplayByID(int id);
	
}