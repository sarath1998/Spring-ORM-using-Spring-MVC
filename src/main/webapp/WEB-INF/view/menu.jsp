<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Navigation bar</title>
<link href="/selexp-lms/webjars1/bootstrap/5.3.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<nav class="navbar bg-dark border-bottom border-bottom-dark" data-bs-theme="dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">SelExpLMS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/selexp-lms/show-Instructors">Our Instructors</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/selexp-lms/add-instructor">Add Instructors</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/selexp-lms/add-course">Add Course</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<script src="/selexp-lms/webjars1/bootstrap/5.3.0/js/bootstrap.min.js"></script>
<script src="/selexp-lms/URLToReachResourcesFolder/js/popper.min.js"></script>
</body>
</html>