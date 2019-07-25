<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:if test="${eData ne null}">
	<div class="head-box">
		<tabel class="header-items">
		<tr>
			<c:if test="${eData.getJob() eq 'HR' }">
				<td><a href="ViewTask">Tasks</a></td>
				<td>|</td>
				<td><a href="ViewReport">View Reports</a></td>
				<td>|</td>
			</c:if>
			<c:if test="${eData.getJob() ne 'HR' }">
				<td><a href="AddReport">Weakly Report</a></td>
				<td>|</td>
				<td><a href="notifications">Notification</a></td>
				<td>|</td>
			</c:if>
				<td><a href="home">Home</a></td>
				<td>|</td>
				<td><a href="logout">Log out</a></td>
		</tr>
		</tabel>
	</div>
	<hr>
</c:if>