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
	<form:form modelAttribute="user" method="post" >
		<table>			
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName"/></td>				
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><form:input path="contactNumber"/></td>
			</tr>
			<tr>
				<td>SSN</td>
				<td><form:input path="ssn"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit"/></td>
			</tr>
		</table>
	</form:form>	
</body>
</html>