<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
</head>
<body>
	<table>
		<tr>
			<td>First Name</td>
			<td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${user.lastName}</td>
		</tr>
		<tr>
			<td>Contact</td>
			<td>${user.contactNumber}</td>
		</tr>
	</table>
</body>
</html>