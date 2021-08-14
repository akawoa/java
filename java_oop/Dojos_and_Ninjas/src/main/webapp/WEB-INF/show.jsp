<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<a href="/">Home</a>
</head>
<body>
	<div class="container">
		<h1>${dojo.name}</h1>

			<ul>
				<c:forEach var="ninja" items="${dojo.ninjas}">
					<li><c:out value="${ninja.firstName}" /> <c:out
							value="${ninja.lastName}" /> - Age:<c:out value="${ninja.age}" />
					</li>
				</c:forEach>
			</ul>


	</div>
</body>
</html>