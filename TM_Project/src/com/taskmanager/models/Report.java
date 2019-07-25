package com.taskmanager.models;

public class Report {
	private int id;
	private int employeeId;
	private String date;
	private String title;
	private String report;
	private String EmployeeName;
	public Report(int id, int employeeId, String date, String title, String report) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.date = date;
		this.title = title;
		this.report = report;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	
}
