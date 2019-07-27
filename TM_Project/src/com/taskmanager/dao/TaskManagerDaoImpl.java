package com.taskmanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.taskmanager.connection.DBConnection;
import com.taskmanager.models.EmployeeData;
import com.taskmanager.models.EmployeeTask;
import com.taskmanager.models.Languages;
import com.taskmanager.models.Projects;
import com.taskmanager.models.Replay;
import com.taskmanager.models.Report;

public class TaskManagerDaoImpl implements TaskManagerDao {

	private DBConnection dbConnection;
	private static TaskManagerDaoImpl taskManagerDaoImpl = null;

	private TaskManagerDaoImpl() {
		dbConnection = new DBConnection();
	}

	public static TaskManagerDaoImpl getinstance() {
		if (taskManagerDaoImpl == null)
			taskManagerDaoImpl = new TaskManagerDaoImpl();
		return taskManagerDaoImpl;
	}

	@Override
	public void registerEmployeeData(String username, String email, String number, String dateOfJoin, int jobSpc,
			String password) {

		String sql = "insert into EmployeeData(fullName,email,phone,languageID,upassword,dateOfJoin,job) values('"
				+ username + "','" + email + "','" + number + "','" + jobSpc + "','" + password + "','" + dateOfJoin
				+ "','normal')"; // login
						// table

		System.out.println("registerEmployeeData-----" + sql);
		dbConnection.putData(sql);
	}

	@Override
	public String getEmployeeType(String username) {
		String sql = "select job from EmployeeData where fullname ='" + username + "'";
		System.out.println("getEmployeeType----" + sql);
		try {
			ResultSet rs = dbConnection.getData(sql);
			rs.next();
			System.out.println(rs.getString(1));
			return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<EmployeeTask> getTaks(int id) {
		ArrayList<EmployeeTask> task = new ArrayList<EmployeeTask>();
		String sql = "select EmployeeTask.*,projects.name from EmployeeTask inner join"
				+ " projects on EmployeeTask.projectID=projects.id where employeeID="+ id +" and completedTime is NULL  ORDER BY deadLine";
		
		System.out.println("getTaks----" + sql);

		ResultSet rs = dbConnection.getData(sql);
		EmployeeTask eTask;
		try {
			while (rs.next()) {
				eTask = new EmployeeTask(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(6),
						rs.getString(6), rs.getString(7));
				eTask.setProjectName(rs.getString(8));
				task.add(eTask);
			}
			System.out.println("no of task : " + task.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}

	@Override
	public ArrayList<Projects> getAllProjects() {
		String sql = "select * from projects";
		ArrayList<Projects> projects = new ArrayList<Projects>();

		System.out.println("getAllProjects----" + sql);

		ResultSet rs = dbConnection.getData(sql);
		try {
			while (rs.next()) {
				projects.add(
						new Projects(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public ArrayList<EmployeeTask> getAllTaksByProjectID() {
		ArrayList<EmployeeTask> task = new ArrayList<EmployeeTask>();
		String sql = "select EmployeeTask.*,projects.name from EmployeeTask inner join projects on EmployeeTask.projectID=projects.id";

		System.out.println("getAllTaks----" + sql);
		ResultSet rs = dbConnection.getData(sql);
		EmployeeTask eTask;
		try {
			while (rs.next()) {
				eTask = new EmployeeTask(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7));
				eTask.setProjectName(rs.getString(8));
				task.add(eTask);
			}
			System.out.println(task.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}

	@Override
	public EmployeeData getEmployee(String username) {
		String sql = "select * from EmployeeData where fullName='" + username + "'";

		System.out.println("getEmployee----" + sql);
		ResultSet rs = dbConnection.getData(sql);
		try {
			if (rs.next()) {
				return new EmployeeData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7),rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkEmployeeLogin(String username, String password) {
		String sql = "select * from EmployeeData where fullname='" + username + "' and upassword='" + password + "'";

		System.out.println("checkEmployeeLogin-----" + sql);
		ResultSet rs = dbConnection.getData(sql);
		try {
			return rs.next();
		} catch (SQLException e) {
		}
		return false;
	}

	@Override
	public ArrayList<Languages> getLanguages() {
		ArrayList<Languages> languages = new ArrayList<>();
		String sql = "select * from languages  where id != 999";

		System.out.println("getLanguages-----" + sql);
		ResultSet rs = dbConnection.getData(sql);
		try {
			while (rs.next()) {
				languages.add(new Languages(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return languages;
	}

	@Override
	public void saveProject(String pname, int id, String discription, String deadLine) {
		String sql = "insert into projects(name,languageID,discription,deadLine) values('" + pname + "'," + id + ",'"
				+ discription + "','" + deadLine + "')";

		System.out.println("saveProject------" + sql);
		dbConnection.putData(sql);
	}

	@Override
	public Projects getProjectById(int id) {
		String sql = "select id,name,languageID from projects where id=" + id;

		System.out.println("getProjectById------" + sql);
		Projects projects = new Projects();
		try {
			ResultSet rs = dbConnection.getData(sql);
			if (rs.next()) {
				projects.setId(rs.getInt(1));
				projects.setName(rs.getString(2));
				projects.setLanguageID(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public ArrayList<EmployeeData> getEmployeeByLanguageId(int languageID) {
		String sql = "select id,fullName from EmployeeData where languageID=" + languageID;
		
		System.out.println("getEmployeeByLanguageId-----"+sql);
		ArrayList<EmployeeData> list=new ArrayList<EmployeeData>();
		try {
			ResultSet rs = dbConnection.getData(sql);
			while(rs.next()) {
				EmployeeData employeeData = new EmployeeData();
				employeeData.setId(rs.getInt(1));
				employeeData.setFullName(rs.getString(2));
				list.add(employeeData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void saveTask(int projectId, int employeeId, String discription, String date, String filePath) {
		String sql="insert into employeeTask(projectId,employeeID,discription,deadLine,filepath) values("+
				projectId+","+employeeId+",'"+discription+"','"+date+"','"+filePath+"')";
		
		System.out.println("saveTask-----"+sql);
		dbConnection.putData(sql);
	}

	@Override
	public void saveReport(int employeeId, String title, String report) {
		String sql="insert into WeaklyReport(employeeID,createdDate,title,report) values("+employeeId+",CURDATE(),'"
				+title+"','"+report+"')";
		
		System.out.println("saveReport-----"+sql);
		dbConnection.putData(sql);
	}

	@Override
	public ArrayList<Report> getAllReport() {
		String sql="select WeaklyReport.*,EmployeeData.fullName from WeaklyReport left join EmployeeData on WeaklyReport.employeeID=EmployeeData.id where WeaklyReport.createdDate >= DATE_SUB(CURDATE(), INTERVAL 7 DAY)";
		System.out.println("getAllTask-----"+sql);
		
		
		ArrayList<Report> reports = new ArrayList<Report>();
		ResultSet rs=dbConnection.getData(sql);
		try {
			while(rs.next()) {
				Report report=new Report(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
				report.setEmployeeName(rs.getString(6));
				reports.add(report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reports;
	}

	@Override
	public void submitTask(int id) {
		String sql="update EmployeeTask set completedTime=CURDATE() where id="+id;
		
		System.out.println("submitTask---"+sql);
		
		dbConnection.putData(sql);
	}

	@Override
	public void deleteProject(int id) {
		String sql1="delete from employeeTask where projectID="+id;
		String sql2="delete from projects where id="+id;
		System.out.println("deleteProject-----"+sql1+"------"+sql2);
		
		dbConnection.updateData(sql1);
		dbConnection.updateData(sql2);
		
	}

	@Override
	public ArrayList<EmployeeTask> getAllTaks() {
		ArrayList<EmployeeTask> tasks = new ArrayList<EmployeeTask>();
		EmployeeTask eTask;
		String sql = "select EmployeeTask.*,projects.name,projects.deadLine,EmployeeData.fullName from EmployeeTask inner join projects "
				+ "on EmployeeTask.projectID=projects.id inner join EmployeeData on EmployeeTask.employeeID=EmployeeData.id ";
		
		System.out.println("getAllTaks------"+sql);
		
		ResultSet rs = dbConnection.getData(sql);
		try {
			while(rs.next()) {
				eTask = new EmployeeTask(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7));
				eTask.setProjectName(rs.getString(8));
				eTask.setProjectDeadline(rs.getString(9));
				eTask.setEmployeeName(rs.getString(10));
				tasks.add(eTask);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public void deleteTask(int id) {
		String sql= "delete from employeeTask where id="+id;
		dbConnection.updateData(sql);
	}

	@Override
	public void addReplay(int id,String replay) {
		String sql = "select EmployeeId from Weaklyreport where id="+id;
		ResultSet rs = dbConnection.getData(sql);
		int empId=0;
		try {
			if(rs.next())
				empId = Integer.parseInt(rs.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sql = "insert into Replay(ReportId,employeeId,replay,seen,createdDate) values("+id+","+empId+",'"+replay+"',0,CURDATE())";
		
		System.out.println("addReplay------------"+sql);
		
		dbConnection.putData(sql);
	}

	@Override
	public ArrayList<Replay> getReplayByID(int id) {
		String sql = "select Replay.*,weaklyReport.title from Replay inner join weaklyReport on Replay.ReportId=weaklyReport.id  where seen=0 and replay.employeeId"
				+ "="+id;
		ArrayList<Replay> replay = new ArrayList<Replay>();
		Replay r;
		System.out.println("getReplayByID------"+sql);
		
		ResultSet rs= dbConnection.getData(sql);
		try {
				while(rs.next()) {
					r=new Replay(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getBoolean(5),rs.getString(6));
					r.setReportTitle(rs.getString(7));
					replay.add(r);
				}
			while(rs.next()) {
				
			}
		}catch(Exception e) {e.printStackTrace();}
		return replay;
	}

	@Override
	public void seenNotification(int id) {
		String sql = "update replay set seen=1 where id="+id;
		
		System.out.println("seenNotification-------"+sql);
		dbConnection.updateData(sql);
	}

}
