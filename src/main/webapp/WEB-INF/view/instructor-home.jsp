<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<link href="/selexp-lms/webjars1/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="/selexp-lms/URLToReachResourcesFolder/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>

<%@include file="menu.jsp"%>

	<div class="container">
		<h1>Available instructors</h1>
		
		<div align="left">
		<form:form action="process-search" method="GET" modelAttribute="searchDTO">
			<label> Search Instructor: </label>
			<form:input path="id"/>
			<input type="submit" value="search">
		</form:form>
		</div>
		
		<div align="right">
			<a href="/selexp-lms/show-Instructors">Refresh list</a>
		</div>
		
		<table class="table">
			<thead class="table-primary">
				<tr>
					<th>S.No</th>
					<th>Instructor ID</th>
					<th>Instructor Name</th>
					<th>Instructor Teaching Exp</th>
					<th>Instructor Email</th>
					<th>Courses</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="instructor" items="${instructorList}" varStatus="itr">
					<tr>
                        <td>${itr.index +1}</td> <!--Printing index[JSP core functionality] instead of the actual Instructor ID. -->
                        <td>${instructor.id}</td>
						<td>${instructor.name}</td>
						<td>${instructor.teachingExp}</td>
						<td>${instructor.email}</td>
						<td>
						 <table class="table">
						   <thead class="table-warning">
						     <tr>
						      <td>name</td>
						      <td>duration</td>
						     </tr>
						   </thead>
						   <tbody>
						   	 <c:forEach var="course" items="${instructor.courses}">
						   	 	<tr>
						   	 	 <td>${course.courseName}</td>
						   	 	 <td>${course.courseDuration}</td>
						   	 	 <td><a href="/selexp-lms/view-Course?courseId=${course.id}">View course</a></td>
						   	 	</tr>
						   	 </c:forEach>
						   
						   </tbody>
						 </table>
						</td>
						<td><a href="/selexp-lms/delete-Instructor?id=${instructor.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>