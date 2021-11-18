<%@page import="com.cov.beans.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.cov.service.DepartmentService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REgistration Page</title>
</head>
<body>
	<form:form action="regEmp" method="post" modelAttribute="employee">
		<br>
		<br>
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>
		
		<input type="submit" value="Register">
	</form:form>
	<br>
	<br>
	<a href="/">Home</a>
	<br>
	<br>
</body>
</html>