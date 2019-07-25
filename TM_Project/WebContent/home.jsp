<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Manager</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<style type="text/css">
table {
	width: 100%; 
	background-color : lightgrey;
	border: 2px solid black;
	background-color: lightgrey;
}

th, td {
	border: 2px solid white;
}

.delete-btn{
	border : none;
	background-color: red;
	color : white;
	font-size: 15px;
	border-radius: 20px;
	padding : 10px;
	margin: 30px;
}
.delete-btn:hover { 
  background-color: black;
}
</style>
<script type="text/javascript">
	function submitTask(a) {
		window.location="SubmitTask?id="+a;
	}
	function deleteProject(id){
		if(confirm("Do you want to delete this Project ?"))	{
			window.location="DeleteProject?id="+id;
		}
	}
</script>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<c:if test="${eData.getFullName() != null}">
		<c:if test="${eData.getJob() eq 'HR' }">
			<!-- HR view -->

			<div id="body">
				<c:forEach items="${projects}" var="p">
					<div class="project-box">
						<label>${p.getName()}</label>
						<h6>${p.getDiscription()}</h6>
						<h6>DeadLine: ${p.getDeadLine()}</h6>
						<!-- <a href="addTask?id=" ${p.getId()} class="assign-box">Assign Task</a> -->
						<a href="assignTask?id=${p.getId()}" class="assign-box">Assign Task</a><br>
						<button class="delete-btn" onClick="deleteProject(${p.getId()})">DELETE</button>
					</div>
				</c:forEach>
				<div class="project-box">
					<div class="box">
						<a href="addProject" class="btn btn-white btn-animation-1">ADD
							PROJECT</a>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${eData.getJob() ne 'HR' }">
			<!-- Employee view -->
			<table>
				<tr>
					<th width="20%">Project Name</th>
					<th width="60%">Description</th>
					<th width="10%">DeadLine</th>
					<th width="10%">Files</th>
				</tr>
				<c:forEach items="${employeeTask}" var="tasks">
					<tr>
						<td>${tasks.getProjectName()}</td>
						<td>${tasks.getDiscription()}</td>
						<td>${tasks.getDeadLine()}</td>
						<td><c:if test="${tasks.getFilePath() ne ''}">
								<a href="download?file=${tasks.getFilePath()}">Download File</a>
							</c:if></td>
						<td><button onclick="submitTask(${tasks.getId()});">Completed</button></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</c:if>
	<c:if test="${eData.getFullName() == null}">
		<c:redirect url="index.jsp"></c:redirect>
	</c:if>
</body>
</html>