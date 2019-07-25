<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weakly Report</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script type="text/javascript">
function showHideDiv(a){
	var x = document.getElementById("hidden-div"+a);
	  if (x.style.display === "block") {
	    x.style.display = "none";
	  } else {
	    x.style.display = "block";
	  }
}
function replay(id){
	var replay=document.getElementById("replay"+id).value;
	console.log(replay);
	window.location="ReplayTask?id="+id+"&replay="+replay;
}
</script>
<style type="text/css">
table {
	width: 100%;
}

.report {
	display: none;
	border-left: 6px solid red;
	background-color: lightgrey;
	border-radius: 6px;
}

.view-btn {
	background-color: blue;
	border: none;
	width: 60px;
	height: 25px;
	color: #ffffff;
}

.view-btn:hover, .replay-btn:hover {
	background-color: black;
}

.replay-btn {
	float: bottom;
	background-color: #edaa77;
	margin-top: 5px;
	border-radius: 20px; border : none;
	width: 60px;
	height: 25px;
	color: #ffffff;
	border: none;
}

.replay-box {
	float: bottom;
	margin-top: 5px;
	width: 60%;
	height: 18px;
}
</style>
</head>
<body>
	<c:if test="${permition}">
		<c:import url="header.jsp"></c:import>
		<div style="margin-right: 60px; font-family: 'Montserrat'">
			<table>
				<tr>
					<th>Name</th>
					<th>Title</th>
					<th>Date</th>
				</tr>
				<c:forEach items="${reports}" var="r">
					<tr>
						<td>${r.getEmployeeName()}</td>
						<td>${r.getTitle()}</td>
						<td>${r.getDate()}</td>
						<td><button class="view-btn"
								onClick="showHideDiv(${r.getId()});">View</button></td>
					</tr>
					<tr>
						<td colspan="4">
							<div id="hidden-div${r.getId()}" class="report">
								<div>${r.getReport()}</div><br>
								<input type="text" id="replay${r.getId()}" class="replay-box"><br>
								<button class="replay-btn" onClick="replay(${r.getId()});">Replay</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
</body>
</html>