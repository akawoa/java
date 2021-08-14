<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Add Ninja</title>
	<a href="/">Home</a>
</head>
<body>
	<div class="container">
		<h1>Who's is joining the Dojo?</h1>
		<form:form action="/ninjas/new" method="post" modelAttribute="ninjasObj">
			<p>
				First Name:
				<form:input type="text" path="firstName"/>
			</p>
						<p>
				Last Name:
				<form:input type="text" path="lastName"/>
			</p>
			<p>
				Age:
				<form:input type="number" path="age"/>
			</p>
			<p>
				Which Dojo do they attend?
				<form:select path="dojo">
					<c:forEach var="dojo" items="${dojos}">
						<form:option value="${dojo.id }">
							<c:out value="${dojo.name}" />
						</form:option>
					</c:forEach>
				</form:select>
			</p>
			
			<button type="submit">Create</button>
		</form:form>
	</div>
</body>
</html>