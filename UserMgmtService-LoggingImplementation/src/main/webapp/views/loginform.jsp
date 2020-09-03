<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <meta http-equiv="X-UA-Compatible" content="IE=EDGE"> -->
<!-- <meta http-equiv="Pragma" content="no-cache"> -->
<!-- <meta http-equiv="Cache-Control" content="no-cache"> -->
<title>Login</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/sty;e.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<jsp:include page="header.jsp"/>
	<jsp:include page="linkbootstrap.jsp"/>
</head>
<body>

	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<marquee><h2 style="color:red">Welcome To Swain Software Technologies</h2></marquee>
		</div>
	</div>

	<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/usermgmt/loginprocess">
					
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="userEmail" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="userPassword"/>
								
						</div>
					</div>
					
					<div class="form-group ">
					<input type="submit" class="btn btn-primary" value="Login"  /><br>
					<a href="/usermgmt/loadform" class="from-control" style="border-radius: 100px;border-color: aqua;">Sign Up</a>
					</div>
					</form>
					</div>
</body><br>
<jsp:include page="footer.jsp"/>
</html>