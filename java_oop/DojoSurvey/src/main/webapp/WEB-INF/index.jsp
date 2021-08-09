<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form method="POST" action="/result" role="form">
				<div class="form-group">

					<label for="name"> Your Name </label> <input name="name"
						type="text" class="form-control" id="name" />
				</div><br>
				<div class="form-group">
					<label for="location">Dojo Location</label> <select
						class="form-control" id="location" name="location">
						<option value="null">Select a Location</option>
						<option value="Bellevue">Bellevue</option>
						<option value="Sane Jose">San Jose</option>
						<option value="Tattooine">Tatooine</option>
						<option value="Eorzea">Eorzea</option>
					</select>
				</div><br>
				<div class="form-group">
					<label for="exampleFormControlSelect1">Favorite Language</label> <select
						class="form-control" id="language" name="language">
						<option>Select a Language</option>
						<option value="Python">Python</option>
						<option value="Java">Java</option>
						<option value="JavaScript">JavaScript</option>
						<option value="C#">C#</option>
					</select>
				</div><br>
				<div class="form-group">
					<label for="comment">Comment(Optional)</label>
					<textarea class="form-control" id="comment"
						rows="5" name="comment"></textarea>
				</div><br>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>