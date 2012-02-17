<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<body>
	<form:form modelAttribute="member" method="post" >
		<table>			
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" cssClass="error" /></td>
								
			</tr>
			<tr>
				<td>Phone</td>
				<td><form:input path="phone"/></td>
				<td><form:errors path="phone" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email"/></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="Submit"/></td>
				<td>&nbsp;</td>
			</tr>
		</table>
	</form:form>	
</body>
</html>