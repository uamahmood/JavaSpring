<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	<title>Add Song</title>

</head>
<body>
	<div class="container">
		<div class="topnav">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="main">
			<form:form action="/songs/new" method="POST" modelAttribute="song">
			<p>	
				<form:label path="title">Title</form:label>
				<form:input path="title"/>
				<span class="errors"><form:errors path="title"/></span>
			
			</p>
			<p> 
				<form:label path="artist">Artist</form:label>
				<form:input path="artist"/>
				<span class="errors"><form:errors path="artist"/></span>
				
			</p>
			<p> 
				<form:label path="rating">Rating (1-10)</form:label>
				<span class="errors"><form:errors path="rating"/></span>
				<form:input type="number" path="rating"/>
			</p>
			<input type="submit" value="submit"/>
			</form:form>
		
		</div>
	</div>
</body>
</html>