<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Boostrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Edit</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<form action="/languages/<c:out value="${language.id}"/>" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" class="btn btn-link" value="delete">
				</form>
				<a class="nav-link" href="/languages">Home </a>
			</div>
			
		</div>
		<div class="row">
			<div class="col p-4">					
				<h2 class="text-center">Edit Language</h2>
			</div>
		</div>
		
		
		<div class="row justify-content-center">
			<div class="col-4 p-2">
				<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		    	<input type="hidden" name="_method" value="put">
		<div class="row justify-content-start">
			<div class="col-6">
				<form:label path="name">Name</form:label>
				<p class="text-danger"><form:errors path="name"/></p>
			</div>
			<div class="col-6">
				<form:input path="name"/>
			</div>
		</div>
		<div class="row justify-content-start">
			<div class="col-6">
				<form:label path="creator">Creator</form:label>
				<p class="text-danger"><form:errors path="creator"/></p>
			</div>
			<div class="col-6">  
				<form:input path="creator"/>
			</div>
		</div>
		<div class="row justify-content-start">
			<div class="col-6">
				<form:label path="version">Version</form:label>
				<p class="text-danger"><form:errors path="version"/></p>
			</div>
			<div class="col-6">  
				<form:input path="version"/>
			</div>
		</div>
		<div class="row justify-content-end">
			<div class="col-2-offset-5">
				<input type="submit" value="Submit" class="btn btn-success"/>
			</div>
		</div>
			</form:form>
		
		
		</div>
		</div>
	</div>
</body>
</html>