<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock Account</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/confirmPwd.js"></script>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<h2>Unlock Account Here</h2>
	<font color='red'>${errMsg}</font>
	
	<form:form action="unlockUserAcc" modelAttribute="unlockAccount" method="POST">
		
		<font color='red'><span id="errId"></span></font>
		<table border="1">
			<tr>
			    <td>Your Email ::</td>
			    <td><form:input path="userEmail" readonly="true"/></td>
			</tr>
			<tr>
			    <td>Enter Temp Password</td>
			    <td><form:password path="tempPassword"/></td>
			</tr>
			<tr>
			    <td>Enter New Password</td>
			    <td><form:password path="newPassword"/></td>
			</tr>
			<tr>
			    <td>Confirm Password</td>
			    <td><form:password path="confirmPassword"/></td>
			</tr>
			<tr>
				<td></td>
			    <td><input type="submit" value="UNLOCK"  onclick="javascript:return validatePwds()"></td>
			</tr>
		</table>	
	</form:form>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>