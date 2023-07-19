<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.seleniumexpress.selexplms.entity.Lesson"%>
<!-- Importing the Java page inside the JSP -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lesson Page</title>

<link href="/selexp-lms/webjars1/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>

<body>
	<%@include file="menu.jsp"%>

	<%
	Lesson lesson = (Lesson) request.getAttribute("lesson");
	int nextLessonId = lesson.getId() + 1;
	pageContext.setAttribute("nextLessonId", nextLessonId);

	int prevLessonId = lesson.getId() - 1;
	pageContext.setAttribute("prevLessonId", prevLessonId); //Making the prevLessonId available to the JSP side using the PageContext
	%>
	
	<div class="container">
		<h2>${lesson.lessonName}</h2>
		<hr />
		<div align="center">${lesson.link}</div>

		<!--  Prev button -->
		<c:if test="${lesson.id > lessonCountDTO.firstLessonNumber}">
			<!-- Used the if tag that is available in the JSP Core tag library -->
			<div align="left">
				<a href="open-lesson?lessonId=${prevLessonId}">previous</a>
				<!--<a href="open-lesson?lessonId=<%=prevLessonId%>">previous</a>  -->
			</div>
		</c:if>

		<!--  Next button -->
		<c:if test="${lesson.id < lessonCountDTO.lastLessonNumber}">
			<div align="right">
				<a href="open-lesson?lessonId=${nextLessonId}">next</a>
			</div>
		</c:if>
	</div>
</body>
</html>