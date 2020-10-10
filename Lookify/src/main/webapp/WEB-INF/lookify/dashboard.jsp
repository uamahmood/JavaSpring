<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<title>Lookify!</title>
</head>
<body>
	<div class="container">
		<div class="topnav">
			<h3><a href="/songs/new">Add New</a>
			<a href="/search/topTen">Top Ten</a></h3>
			<form action="/search" class="search" method="get">
				<input type="text" name="artist"/>
				<button type="submit">Search Artists</button>
			</form>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td><a href="/songs/${ song.id }">${ song.title }</a></td>
					<td>${ song.rating }</td>
					<td>
						<form action="/songs/<c:out value="${song.id}"/>" method="post">
					    	<input type="hidden" name="_method" value="delete">
		    				<input type="submit" class="btn btn-link" value="delete">
					    </form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
