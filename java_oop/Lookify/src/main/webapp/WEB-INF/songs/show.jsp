<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${song.title}" /></title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<a href="/songs">Home</a>
</head>
<body>
	<h1>
		<c:out value="${song.title}" />
	</h1>
	<p>
		Title:
		<c:out value="${song.title}" />
	</p>
	<p>
		Artist:
		<c:out value="${song.artist}" />
	</p>
	<p>
		Rating(1-10):
		<c:out value="${song.rating}" />
	</p>
	<br>
	<br>
	<br>
	<br>
	<form action="/songs/${song.id}" method="post">
		<input type="hidden" name="_method" value="delete"> <input
			type="submit" value="Delete">
	</form>
	<br>
	<br>

</body>
</html>