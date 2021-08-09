<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Code</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<p style="color:red"><c:out value="${error}"/></p>
			<form method="POST" action="/process" role="form">
				<div class="form-group">
					 
					<label for="password">
						What is the code?
					</label>
					<input name="password" type="password" class="form-control" id="password" />
				</div><br>
				<button type="submit" class="btn btn-primary">
					Try Code
				</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>