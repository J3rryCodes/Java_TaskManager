package com.taskmanager.models;

public class Projects {
	int id;
	String name;
	int languageID;
	String discription;
	String deadLine;
	public Projects() {
	}
	
	public Projects(int id, String name, int languageID, String discription, String deadLine) {
		super();
		this.id = id;
		this.name = name;
		this.languageID = languageID;
		this.discription = discription;
		this.deadLine = deadLine;
	}

	public int getLanguageID() {
		return languageID;
	}
	public void setLanguageID(int languageID) {
		this.languageID = languageID;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
}
