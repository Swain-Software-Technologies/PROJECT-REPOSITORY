<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/dropdown.js"></script>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

	<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<marquee><h2 style="color:red">Welcome To Swain Software Technologies</h2></marquee>
		</div>
	</div>
<!-- <div style="text-align: center; color: red;" ><marquee><h1><b>User Management Service System<b></b></h1></marquee></div> -->

<!-- 	 <div style="text-align: center; color: aqua; box-shadow: black;" align="right" > -->
<div class="container text-center">
	<h2><center>User Registration Form</center></h2>
	<hr>
	<form:form action="userAccReg" method="post" modelAttribute="userAccount" >
			<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<form:input class="form-control" path="usrfirstName"/><br>
						</div>
			</div>
			<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<form:input class="form-control" path="usrLastName"/><br>
						</div>
			</div>
			<div class="form-group">
						<label class="control-label col-md-3">Email</label>
						<div class="col-md-7">
							<form:input class="form-control" path="userEmail"/><br>
						</div>
			</div>
			<div class="form-group">
						<label class="control-label col-md-3">Mobile</label>
						<div class="col-md-7">
							<form:input class="form-control" path="userPhoneNumber"/><br>
						</div>
			</div><br><br>
			<div class="form-group">
						<label class="control-label col-md-3">DOB</label>
						<div class="col-md-7">
							<form:input class="form-control" path="dateOfBirth"/>
						</div><br>
			</div>
			
			<div>
					<label class="control-label col-md-3">Gender</label>	
						<div class="col-md-7">	
								<div class=""form-control>	
									<h5><b>Male</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:radiobutton path="userGender" value="M" id="gender"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<b>Female</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:radiobutton path="userGender" value="F" id="gender"/></h5>
								</div>
						</div>	
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">Country</label>	
					<div class="col-md-7">							
						<form:select class="form-control" path="countryId">
								<form:option value="">---Select---</form:option>
								<form:options items="${countryMap}"/>
						</form:select><br>
					</div>	
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">State</label>	
					<div class="col-md-7">							
						<form:select class="form-control" path="stateId">
								<form:option value="">---Select---</form:option>
						</form:select><br>
					</div>	
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">City</label>	
					<div class="col-md-7">							
						<form:select class="form-control" path="cityId">
								<form:option value="">---Select---</form:option>
						</form:select><br>
					</div>	
			</div>
			<div class="form-group ">
			<label class="control-label col-md-3"></label>
						<div class="col-md-7">
						<input type="reset" class="btn btn-danger" value="Reset" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="submit" class="btn btn-primary" value="Register" />
						</div>
			</div>
			</form:form>
	</div>			
</body><br>
<jsp:include page="footer.jsp"></jsp:include>
</html>