<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Project</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>
	<c:if test="${eData.getFullName() != null}">
		<c:if test="${eData.getJob() eq 'HR' }">
			<c:import url="header.jsp"></c:import>
			<form action="saveProject">
				<input type="text" name="pname">
				<select name="language">
					<option value=0>-Select Language-</option>
					<c:forEach items="${languages}" var="l">
						<option value="${l.getId()}">${l.getLanguage()}</option>
					</c:forEach>
				</select>
				<textarea rows="7" cols="35" name="discription"></textarea>
				<input type="date" name="deadLine">
				
				<input type="submit" value="Save">
			</form>
		</c:if>
	</c:if>
</body>
</html>