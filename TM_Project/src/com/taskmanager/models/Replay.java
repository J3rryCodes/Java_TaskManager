package com.taskmanager.models;

public class Replay {
	private int id;
	private int taskId;
	private int employeeId;
	private String replay;
	boolean seen;
	String createdDate;
	String reportTitle;

	public Replay() {
		super();
	}

	public Replay(int id, int taskId, int employeeId, String replay, boolean seen, String createdDate) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.employeeId = employeeId;
		this.replay = replay;
		this.seen = seen;
		this.createdDate = createdDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getReplay() {
		return replay;
	}

	public void setReplay(String replay) {
		this.replay = replay;
	}

	public boolean isSeen() {
		return seen;
	}

	public void setSeen(boolean seen) {
		this.seen = seen;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	
}
