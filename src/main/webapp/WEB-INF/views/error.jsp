<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<c:if test="${not empty errCode}">
		<h3>${errCode} : System Errors</h3>
	</c:if>
	
	<c:if test="${empty errCode}">
		<h3>System Errors</h3>
	</c:if>

	<c:if test="${not empty errMsg}">
		<h3>${errMsg}</h3>
	</c:if>
	
</body>
</html>