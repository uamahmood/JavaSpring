<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
	<title>Details</title>
</head>
<body>
	<div class="container">
		<div class="topnav">
			<a href="/dashboard">Dashboard</a>
		</div>
		<div class="info">
			<h3>Song Title</h3>
			${ song.title }
			<h3>Artist</h3>
			${ song.artist }
			<h3>Rating</h3>
			${ song.rating }
			<form action="/songs/${ song.id }" method="post">
				<input type="hidden" name="_method" value="delete" />
				<input type="submit" value="Delete" />
			</form>
		</div>
	</div>
</body>
</html>