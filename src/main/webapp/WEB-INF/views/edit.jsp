<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

    <div class="col-sm-4" style="padding:20px;">
    <c:if test="${error != null }"> <h3>${error}</h3> </c:if>
        <h2>Create Your TODO</h2>
        <form action="update" method="post" id="update">
        	<input type="hidden" value="${ todolist.id }" id="id" name="id">
            <div class="form-group">
            <label>Title</label>
            <input type="text" name="title" id="title" class="form-control" value="${ todolist.title }">
            </div>
            <div class="form-group">
            <label>Message</label>
            <input type="text" name="message" id="message" class="form-control" value="${ todolist.message }" >
            </div>
            <div class="form-group">
            <label>Estimation</label>
            <input type="text" name="estimation" id="estimation" class="form-control" value="${ todolist.estimation }">
            </div>
            <div class="form-group">
            <label>Status</label>
            <input type="text" name="status" id="status" class="form-control" value="${ todolist.status }" >
            </div>
            <div class="form-group">
            <label>Start Date</label>
            <input type="date" name="startdate" id="startdate" class="form-control" value="${ todolist.startdate }"
            pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" 
            >
            </div>
            <div class="form-group">
            <label>Due Date</label>
            <input type="date" name="duedate" id="duedate" class="form-control" value="${ todolist.duedate }"
            pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))" 
            >
            </div>
            <div class="form-group">
            <input type="button" value="Update" class="btn btn-primary" id="add">
            </div>
        </form>
        <script src="resources/js/todoAdd.js"></script>
    </div>
