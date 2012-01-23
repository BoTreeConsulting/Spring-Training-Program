<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
	<table>
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Contact Number</td>
			<td>View</td>
			<td>Edit</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.contactNumber}</td>
				<td><a href="user/view/${user.id}">View</a></td>
				<td><a href="user/update/${user.id}">Update</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td><a href="user/add">Add</a></td>
		</tr>
	</table>
</body>
</html>