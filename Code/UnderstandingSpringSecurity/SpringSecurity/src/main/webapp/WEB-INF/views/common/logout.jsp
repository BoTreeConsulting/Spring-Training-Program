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
			<form:form>
				<div class="login_box">					
					<h1>You have Logged Out Successfully!</h1>
					<br/>
					<h2><a href="login">Login Again</a></h2>
				</div>				
			</form:form>
		</div>		
	</div>
	<!-- End Main part -->
</body>
</html>