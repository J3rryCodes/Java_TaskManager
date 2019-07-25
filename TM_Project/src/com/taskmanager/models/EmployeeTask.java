package com.taskmanager.models;

public class EmployeeTask {
	int id;
	int projectID;
	int employeeID;
	
	
	String employeeName;
	
	String deadLine;
	String completedTime;
	String discription;
	String projectName;
	String filePath;
	String projectDeadline;
	
	public EmployeeTask() {
	}
	
	public EmployeeTask(int id, int projectID, int employeeID, String deadLine, String completedTime,
			String discription, String filePath) {
		super();
		this.id = id;
		this.projectID = projectID;
		this.employeeID = employeeID;
		this.deadLine = deadLine;
		this.completedTime = completedTime;
		this.discription = discription;
		this.filePath = filePath;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	public String getCompletedTime() {
		return completedTime;
	}
	public void setCompletedTime(String completedTime) {
		this.completedTime = completedTime;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getProjectDeadline() {
		return projectDeadline;
	}

	public void setProjectDeadline(String projectDeadline) {
		this.projectDeadline = projectDeadline;
	}
	
}
