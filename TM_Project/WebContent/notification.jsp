<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notifications</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script>
function fun(id){
	alert(id);
	window.location="seenNotificaation?id="+id;
}
</script>
</head>
<body>
<c:if test="${eData.getFullName() != null}">
		<c:import url="header.jsp"></c:import>
		<table>
		<c:forEach items="${replays}" var="r">
			<tr><td>${r.getReplay()}</td>
			<td>${r.getReportTitle()}</td>
			<td><button onClick="fun(${r.getId()});">OK</button></td>
			</tr>
		</c:forEach>
		</table>
</c:if>
<c:if test="${eData.getFullName() == null}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>
</body>
</html>