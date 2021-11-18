<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>



<meta charset="ISO-8859-1">
<title>RegEmployee</title>
</head>
<body>
	<h2>Employee Registration</h2>
	<form:form action="regemps" method="post" modelAttribute="employee">

		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		<!--
<label for="Department">Choose Department</label>

<select name="Department" id="dept">
<option value="20">20</option>
<option value="20">30</option>
</select>
<br>
<br> -->
		<input type="submit" value="Register">
	</form:form>

</body>
</html>