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
		<h2>${courseDTO.courseName} - lessons page</h2>
		<hr />
		<h4>The lessons under this course are:</h4>
		<c:forEach var="lesson" items="${pagedListHolder.pageList}" varStatus="itr">
			<!-- each instructor have courses -->
			<!-- each course have many lessons -->
			<table>
				<tr>
					<td>${lesson.id}</td>
					<!--  Display the serial Number(using the index) instead of actual Lesson number -->
					<td>.</td>
					<td><a href="open-lesson?lessonId=${lesson.id}">${lesson.lessonName}</a></td>
				</tr>
			</table>
		</c:forEach>

		<div align="center">
			<table>
				<tr>
				    <!--  Prev Button -->
					<td> 
						<c:choose>
							<c:when test="${pagedListHolder.firstPage}"> <!--  Do not display Prev for 1st page -->
							   
		    				</c:when>
							<c:otherwise>
								<a href="view-Course?courseId=${courseDTO.id}&pageNum=prev">Prev</a>
								&nbsp;
							</c:otherwise>
						</c:choose>
					</td>
					
					<!--  Actual Page Nos -->
					<c:forEach begin="0" end="${pagedListHolder.pageCount - 1}" varStatus="itr">
						<td>
						   <c:choose>
								<c:when test="${pagedListHolder.page == itr.index}">  <!-- Do not display hyperlink for the current page -->
		           	 				${itr.index + 1} 
		        				</c:when>
						    	<c:otherwise>
									<a href="view-Course?courseId=${courseDTO.id}&pageNum=${itr.index}">${itr.index+1}</a> <!-- Only show hyperlink to other page nos --> 
								</c:otherwise> <!-- Showing the dummy page Nos, instead of showing the original Nos -->
							</c:choose>
							&nbsp;
						</td>
					</c:forEach>
					
					<!--  Next Button -->
					<td>
						<c:choose>
							<c:when test="${pagedListHolder.lastPage}">  <!--  Do not display next for last page -->
		       				
		    			</c:when>
							<c:otherwise>
								<a href="view-Course?courseId=${courseDTO.id}&pageNum=next">Next</a>
								&nbsp;
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>