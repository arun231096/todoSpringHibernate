<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<c:if test="${not empty lists}">
	<%
		int count =1;
	%>
		<table border="1" class="table table-striped">
			<tr>
				<th>S.No</th>
				<th>Title</th>
				<th>Estimation</th>
				<th>Start Date</th>
				<th>Due Date</th>
				<th>Message</th>
				<th>Status</th>
				<th>Edit Progress</th>
				<th>Remove Progress</th>
			</tr>
			<c:forEach var="listValue" items="${lists}">
				<tr>
					<td><% out.println(count); count++; %></td>
					<td>${listValue.title}</td>
					<td>${listValue.estimation}</td>
					<td>${listValue.startdate}</td>
					<td>${listValue.duedate}</td>
					<td>${listValue.message}</td>
					<td>${listValue.status}</td>
					<td>
						<input type="button" value="Edit" onclick="readData(${listValue.id})" class="btn btn-primary center-block">
					</td>
					<td>
						<input type="button" value="Delete" onclick="deleteData(${listValue.id})" class="btn btn-danger center-block">
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty lists}"> 
		<h3 align="center">NO DATA AVAILABLE</h3>
		<script>
			$("#next").prop('disabled', true);
		</script>
	</c:if>
	