<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Contact</title>
<style>
				body {
					margin: 0;
					font-family: Arial, Helvetica, sans-serif;
				}
				
				.topnav {
					overflow: hidden;
					background-color: #333;
				}
				
				.topnav a {
					float: left;
					color: #f2f2f2;
					text-align: center;
					padding: 14px 16px;
					text-decoration: none;
					font-size: 17px;
				}
				
				.topnav a:hover {
					background-color: #ddd;
					color: black;
				}
				
				.topnav a.active {
					background-color: #4CAF50;
					color: white;
				}
</style>
</head>
<body bgcolor="pink">

	<div class="topnav">
		<a class="active">Phone Book</a>
		 <a href="addContacts">Add New Contacts</a> 
		<a href="viewContacts">Show All Contacts</a>
	   
	</div>

	<div  style="padding-left: 50px" >

		<h1>
			<center>
				Save Contact
				<center></center>
		</h1>

		<p>
			<font color="green">${successMsg}</font>
		</p>
		<p>
			<font color="red">${errorMsg}</font>
		</p>
		<form:form action="saveContact" modelAttribute="contact" method="post">
			<table>
				<tr>
					<form:hidden path="contactId" />
					<td>Contact Name :</td>
					<td><form:input path="contactName" /></td>
				</tr>
				<tr>
					<td>Contact Email :</td>
					<td><form:input path="contactEmail" /></td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td><input type="reset" value="Reset" /></td>
					<td><input type="submit" value="Save"/></td>
				</tr>
			</table>
		</form:form>
		
	</div>


</body>
</html>