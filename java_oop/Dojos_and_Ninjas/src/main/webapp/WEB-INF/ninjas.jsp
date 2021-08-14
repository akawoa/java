<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/pricing/">
	<title>Add Ninja</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link active" href="/">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/dojos/new">Add
						New Dojo</a></li>
				<li class="nav-item"><a class="nav-link" href="/ninjas/new">Add
						New Ninja</a></li>
			</ul>
		</div>
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