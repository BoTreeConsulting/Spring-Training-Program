<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Secure System Panel</title>
	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main">
		<!-- Start Main part -->
		<div id="header">
			<jsp:include page="header.jsp"/>		
		</div>
		<!-- End Header part -->
		<div id="container">
			<!-- Start Container part -->
			<form:form action="j_spring_security_check" method="POST">
				<div class="login_box">
					<!-- Start Login Box -->
					<h1>Login</h1>
					<ul>
						<li class="loginform">
							<label for="j_username" class="small">User Name:</label> 
							<input id="j_username" name="j_username" type="text"/>
						</li>
						<li class="loginform">
							<label for="j_password" class="small">Password:</label> 
							<input id="j_password" name="j_password" type="password" />
						</li>
						<li class="loginform-submit"><input type="submit" class="submit" value="Login" /> 
						<input type="reset"	class="reset" value="Reset" /></li>
					</ul>
				</div>
				<!-- End Login Box -->
			</form:form>
		</div>		
	</div>
	<!-- End Main part -->
</body>
</html>