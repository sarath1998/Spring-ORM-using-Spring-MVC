<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course Page</title>
<link href="/selexp-lms/webjars1/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<h1>Add New Course</h1>
		<form:form action="submit-course" method="POST"
			modelAttribute="course">
			<label>Course Name: </label>
			<form:input path="courseName" />
			<br />
			<label>Course Duration: </label>
			<form:input path="courseDuration" />
			<br />
			<label>Instructors: </label>
			<form:select path="instructor.id">
				<form:options items="${allInstructors}" itemLabel="name" itemValue="id" />
			</form:select>
			<input type="submit" value="Add course"/>
		</form:form>
	</div>
</body>
</html>