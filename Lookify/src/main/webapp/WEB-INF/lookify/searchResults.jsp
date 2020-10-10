<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	<title>Search</title>
</head>
<body>
	
	<div class="container">
		<h3>Searched for: ${ artist }</h3>
		<div class="topnav">
			<a href="/dashboard">Dashboard</a>
			<form class="search" action="/songs/search">
				<input type="text" name="artist"/>
				<button>Search Artists</button>
			</form>
		
		</div>
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td><a href="/songs/${ song.id }">${ song.title }</a></td>
					<td>${ song.artist }</td>
					<td>${ song.rating }</td>
					<td><a  href="/delete/${ song.id }">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>