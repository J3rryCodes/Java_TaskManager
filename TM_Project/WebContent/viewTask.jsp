<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Task</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<style type="text/css">
.task-view-table {
	margin-top : 30px;
	width: 100%; 
	border: 2px solid black;
	font-family: 'Montserrat';
}

th, td {
	border: 2px solid white;
}
.completed-table{
	background-color: #f7f5c8;
}
.Pending-table{
	background-color: #f7c8c8;
}
.delete-btn{
	border: none;
	width: 60px;
	height: 25px;
	background-color: red;
	color : #ffffff;
	border-radius: 12px;
}
.delete-btn:hover {
	background-color: black;
}
</style>
<script type="text/javascript">
function deleteTask(id){
	window.location="DeleteTask?id="+id;
}
</script>
</head>
<body>
	<c:if test="${eData.getJob() eq 'HR' }">
		<c:import url="header.jsp"></c:import>
		
<!-- ------------------------------------ Completed ---------------------------------------------------------- -->
		<table class="task-view-table completed-table" border="1">
		<tr>
		<th colspan="6">COMPLETED TASK</th>
		</tr>
			<tr>
				<th width="25%">Project</th>
				<th width="20%">Responsible Person</th>
				<th width="26%">Task</th>
				<th width="12%">Task Deadline</th>
				<th width="12%">Project Deadline</th>
			</tr>
			<c:forEach items="${tasks}" var="task">
				<c:if test="${task.getCompletedTime() ne null}">
					<tr>
						<td>${task.getProjectName()}</td>
						<td>${task.getEmployeeName()}</td>
						<td>${task.getDiscription()}</td>
						<td>${task.getDeadLine()}</td>
						<td>${task.getProjectDeadline()}</td>
						<td><button class="delete-btn" onClick="deleteTask(${task.getId()})">Delete</button>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		
<!-- ------------------------------------- Pending ------------------------------------------------------------- -->
		
		<table class="task-view-table Pending-table" border="1">
		<tr>
		<th colspan="6">PENDING TASK</th>
		</tr>
			<tr>
				<th width="25%">Project</th>
				<th width="20%">Responsible Person</th>
				<th width="26%">Task</th>
				<th width="12%">Task Deadline</th>
				<th width="12%">Project Deadline</th>
			</tr>
			<c:forEach items="${tasks}" var="task">
				<c:if test="${task.getCompletedTime() eq null}">
					<tr>
						<td>${task.getProjectName()}</td>
						<td>${task.getEmployeeName()}</td>
						<td>${task.getDiscription()}</td>
						<td>${task.getDeadLine()}</td>
						<td>${task.getProjectDeadline()}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		
	</c:if>
</body>
</html>