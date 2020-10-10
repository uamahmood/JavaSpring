<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Boostrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Languages</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mb-2">
			<div class="col p-4">
				<h1 class="text-center">List of Languages</h1>
			</div>
		</div>
		<div class="row">
			 <table class="table table-bordered table-striped">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Creator</th>
						<th scope="col">Version</th>
						<th scope="col">Actions</th>
					</tr>					        		
				</thead>
				<c:forEach items="${languages}" var="language">								    
					<tr>
						<td><a href="/languages/<c:out value="${language.id}"/>"><c:out value="${language.name}"/></a></td>
						<td><c:out value="${language.creator}"/></td>
						<td><c:out value="${language.version}"/></td>
						<td>
							<div class="row">
								<div class="col-sm-6 border-right">
									<form action="/languages/<c:out value="${language.id}"/>" method="delete">
									<input type="hidden" name="_method" value="delete">
						    		<input type="submit" class="btn btn-link" value="delete">
									</form>
								</div>
								<div class="col-sm-6 border-left">
									<form action="/languages/${language.id}/edit" method="get">
						    		<input type="submit" class="btn btn-link" value="edit">
									</form>
								</div>
							</div>				
		
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="row justify-content-center mb-4">
			<div class="col">
				<h2 class="text-center">New Language</h2>
				</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-4 p-2">
				<form:form action="/languages" method="post" modelAttribute="language">
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
				
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>