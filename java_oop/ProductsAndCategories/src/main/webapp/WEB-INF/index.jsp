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

	<title>Dashboard</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link active" href="/">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/categories/new">Add
						New Category</a></li>
				<li class="nav-item"><a class="nav-link" href="/products/new">Add
						New product</a></li>
			</ul>
		</div>
	<div class="container">
		<h1>All Categories</h1>
		<c:forEach var="category" items="${categories}">
			<p><a href="categories/${category.id}"><c:out value="${category.name}" /></a>			
			</p>
		</c:forEach>
	</div>
		<div class="container">
		<h2>All Products</h2>
		<c:forEach var="product" items="${products}">
			<p><a href="products/${product.id}"><c:out value="${product.name}" /></a>			
			</p>
		</c:forEach>
	</div>
</body>
</html>