<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="resources/css/style.css">
  <script src="resources/js/service.js"></script>
  <script src="resources/js/validation.js"></script>
  <script src="resources/js/jqueryService.js"></script>
  <script src="resources/js/script.js"></script>
</head>
<body>
	<div class="container" style="padding:20px;">
		<h1>Welcome to ToDo!</h1>
		<c:if test="${error != null }"> <h3>${error}</h3> </c:if>
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4"></div>
			<div class="col-sm-4" align="right">
		       <button class="btn btn-info" id="addtodo">Add ToDo</button>
			</div>
		</div>
		<div class="row" id="selection">
			<div class="col-sm-10">
				<input type="text" id="title_search" name="title" class="search" placeholder="Search">
				<button class="btn btn-warning btn-md" id="clear">Clear</button>
			</div>
			<div class="col-sm-1" align="right">
				<button class="btn btn-link" id="back">Back</button>
			</div>
			<div class="col-sm-1" align="right">
				<button class="btn btn-link" id="next">Next</button>
			</div>
		</div>
		<div class="row content" id="content">
		</div>
	</div>
</body>
</html>
