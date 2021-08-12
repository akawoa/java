<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
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
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			<ul class="nav">
				<li class="nav-item">
					<a class="nav-link active" href="/songs/new">Add New</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/songs/topten">Top Ten</a>
				</li>
			</ul>
		</div>
		<div class="col-md-3">
			<form role="form" name="search" action="songs/search" method="post">
				<div class="form-group">
					 
					<label for="search">
						Search
					</label>
					<input type="text" class="form-control" id="search" name="search" />
									
				</div>
				<div class="col-md-3">
<button type="submit" class="btn btn-primary">
					Submit
				</button>
				</div>
			</form>
		</div>
	</div>
</div>
	<h1>All Songs</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Title</th>
							<th>Artist</th>
							<th>Rating</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${songs}" var="song">
							<tr>
								<td><a href="/songs/${song.id}"><c:out
											value="${song.title}" /></a></td>
								<td><c:out value="${song.artist}" /></td>
								<td><c:out value="${song.rating}" /></td>
								<td><a href="/songs/edit/${song.id}">Edit</a> | <a
									href="/songs/delete/${song.id}">Delete</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>