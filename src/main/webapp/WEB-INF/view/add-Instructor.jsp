<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Instructor Page</title>
<link href="/selexp-lms/webjars1/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="menu.jsp"%>
<h1>Add Instructor</h1>
	<form:form action="submit-instructor" method="POST" modelAttribute="instructor">
	  <label>Name: </label>
	  <form:input path="name"/>
	  <br/>
	  <label>Teaching Exp: </label>
	  <form:input path="teachingExp"/>
	  <br/>
	  <label>email: </label>
	  <form:input path="email"/>
	  <br/>		  
	  <input type="submit" value="Add"/>
	</form:form>
</body>
</html>