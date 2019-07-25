<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Report</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<style>
.button-class {
	float: right;
	background-color: #595ec9;
	font-size: 15px;
	font-family: 'Russo One';
	font-color: #ffffff;
}
</style>
</head>
<body>
	<c:if test="${eData.getFullName() != null}">
		<c:import url="header.jsp"></c:import>

		<div style="margin-right: 60px; font-family: 'Montserrat'">

			<form action="saveReport" method="post">
				<input type="hidden" value="${eData.getId()}" name="id">
				<div style="margin-bottom: 20px;">
					Title : <input type="text" name="title" style="width: 60%;"><br>
				</div>
				Report :<br>
				<textarea rows="28" cols="181" name="report"></textarea>
				<br> <input type="submit" value="Submit Report"
					class="button-class">
			</form>

		</div>

	</c:if>

</body>
</html>