<%@ include file="../common/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Secure System</title>
	<link href="resources/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="main">
		<!-- Start Main part -->
		<div id="header">
			<jsp:include page="../common/header.jsp"/>		
		</div>
		<!-- End Header part -->
		<div id="container">
			<!-- Start Container part -->
			<form:form>
				<div class="login_box">
					<h1>ADMIN Login Successful!</h1>
					<br/>
					<h2><a href="logout">Logout</a></h2>
				</div>
				<!-- End Login Box -->
			</form:form>
		</div>		
	</div>
	<!-- End Main part -->
</body>
</html>