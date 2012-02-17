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
	<form:form modelAttribute="userLogin" method="post" >
		<form:errors path="*" cssClass="error" />	
		<table>			
			<tr>
				<td>User Name</td>
				<td><form:input path="userName"/></td>
				<td><form:errors path="userName" cssClass="error" /></td>
								
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"/></td>
				<td><form:errors path="password" cssClass="error" /></td>
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