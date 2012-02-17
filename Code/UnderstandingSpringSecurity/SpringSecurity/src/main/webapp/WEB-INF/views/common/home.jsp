<%@ include file="include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Booking Administrator Panel</title>
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
			<form:form>
				<div>					
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<p><a  href="admin">You are an Admin!</a></p>
					</sec:authorize>
									
					<sec:authorize access="hasRole('ROLE_USER')">		
						<p><a  href="agent">You are a User!</a></p>					
					</sec:authorize>
					
					<p><a href="logout">Logout</a></p>
					
				</div>
				
			</form:form>
		</div>		
	</div>
	<!-- End Main part -->
</body>
</html>