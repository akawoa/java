<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Language Index</title>
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



<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>All Languages</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Creator</th>
							<th>Version</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${languages}" var="language">
							<tr>
								<td><a href="/languages/${language.id}"><c:out
											value="${language.name}" /></a></td>
								<td><c:out value="${language.creator}" /></td>
								<td><c:out value="${language.version}" /></td>
								<td><a href="/languages/${language.id}/edit">Edit</a> | <a href="/languages/delete/${language.id}">Delete</a></td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div>
		<h2>New Language</h2>
		<form:form method="POST" action="/languages/process"
			modelAttribute="language">
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="creator">Creator</form:label>
				<form:errors path="creator" />
				<form:textarea path="creator" />
			</p>
			<p>
				<form:label path="version">Version</form:label>
				<form:errors path="version" />
				<form:input path="version" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>
		<br> <br> <br> <br>
	</div>


	<a href="/languages/new">New Language</a>
</body>
</html>