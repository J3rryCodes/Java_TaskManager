package com.taskmanager.models;

public class EmployeeData {
	int id;
	String fullName;
	String email;
	String phone;
	int languageId;
	String upassword;
	String dateOfJoin;
	String job;

	
	
	public EmployeeData(int id, String fullName, String email, String phone, int languageId, String upassword,
			String dateOfJoin, String job) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.languageId = languageId;
		this.upassword = upassword;
		this.dateOfJoin = dateOfJoin;
		this.job = job;
	}


	public EmployeeData() {
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public int getLanguageId() {
		return languageId;
	}



	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

}
