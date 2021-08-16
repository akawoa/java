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
	<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1><c:out value="${category.name}" /></h1>
		<ul>
			<c:forEach var="product" items="${category.products}">
				<li>
					<c:out value="${product.name}" />
				</li>
				
			</c:forEach>
		</ul>
		
		<form action="/categories/${category.id}" method="POST">
			<select name="product_id" id="">
				<c:forEach var="product" items="${products}">
					<option value="${product.id}">
						<c:out value="${product.name}" />
					</option>
				</c:forEach>
			</select>
			<button>Add Product</button>
		</form>
		
	</div>
</body>
</html>