<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>
	<c:if test="${eData.getFullName() != null}">
		<c:if test="${eData.getJob() eq 'HR' }">
			<c:import url="header.jsp"></c:import>
			<form action="saveTask"  method="POST" enctype="multipart/form-data">
				<label>${project.getName()}</label>
				<input type="hidden" name="projectId" value="${project.getId()}">
				<select name="employeeId">
					<c:forEach items="${employees}" var="e">
					<option value="${e.getId()}">${e.getFullName()}</option>
					</c:forEach>
				</select>
				<textarea rows="7" cols="35" name="discription"></textarea>
				<input type="date" name="deadLine">
				<input type="file" name="projectFile">
				<input type="submit" value="SAVE">
			</form>
		</c:if>
	</c:if>
</body>
</html>