<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course-Lessons List Page</title>
<link href="/selexp-lms/webjars1/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<h2>${course.courseName} - lessons page</h2>
		<hr />
		<h3>The lessons under this course are:</h3>
		<c:forEach var="lesson" items="${course.lessons}" varStatus="itr">
			<!-- each instructor have courses -->
			<!-- each course have many lessons -->
			<table>
				<tr>
					<td>${itr.index + 1}</td> <!--  Display the Dummy serial Number instead of actual Lesson number -->
					<td>.</td>
					<td><a href="open-lesson?lessonId=${lesson.id}">${lesson.lessonName}</a></td>
				</tr>
			</table>
		</c:forEach>
	</div>
</body>
</html>