<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<meta charset="ISO-8859-1">


		<script>
			$(document).ready(function() {
			    $('#contactTable').DataTable( {
			        "pagingType": "full_numbers"
			    } );
			} );
			
		</script>

<title>All Contacts</title>
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

</head>
<body bgcolor="cyan">

	<h3>All Contacts :::</h3><table border="1" style="color: red; width: 3" id="contactTable">
		<thead>
			<tr>
				<th>Sr No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone No.</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contacts}" var="c" varStatus="index">
				<tr>
					<td>${index.count+1}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td>
						<a href="editContact?contactId=${c.contactId}">Edit</a> ||
					    <a href="deleteContact?contactId=${c.contactId}" onclick="return confirm('Are you sure .You want to delete ?');">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table><br><br>
	
</body>
</html>