<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/pricing/">



<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>


<!-- Custom styles for this template -->
<link href="style.css" rel="stylesheet">
</head>
<body>

	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
  <symbol id="check" viewBox="0 0 16 16">
    <title>Check</title>
    <path
			d="M13.854 3.646a.5.5 0 0 1 0 .708l-7 7a.5.5 0 0 1-.708 0l-3.5-3.5a.5.5 0 1 1 .708-.708L6.5 10.293l6.646-6.647a.5.5 0 0 1 .708 0z" />
  </symbol>
</svg>

	<div class="container py-3">
		<header>

			<h3>
				Your Gold:
				<c:out value="${totalGold}"></c:out>
			</h3>
	</div>
	</header>

	<main>
		<div class="row row-cols-1 row-cols-md-4 mb-3 text-center">
			<div class="col">
				<div class="card mb-4 rounded-3 shadow-sm border-primary">
					<div class="card-header py-3 text-white bg-primary border-primary">
						<h4 class="my-0 fw-normal">Farm</h4>
					</div>
					<div class="card-body">
						<h2 class="card-title pricing-card-title">(Earns 10-20 golds)</h2>
						<form action="/process_money" method="post">
							<input type="hidden" name="building" value="farm" />
							<button type="submit" class="w-100 btn btn-lg btn-primary">Find
								gold!</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mb-4 rounded-3 shadow-sm border-primary">
					<div class="card-header py-3 text-white bg-primary border-primary">
						<h4 class="my-0 fw-normal">Cave</h4>
					</div>
					<div class="card-body">
						<h2 class="card-title pricing-card-title">(Earns 5-10 golds)</h2>
						<form action="/process_money" method="post">
							<input type="hidden" name="building" value="cave" />
							<button type="submit" class="w-100 btn btn-lg btn-primary">Find
								gold!</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mb-4 rounded-3 shadow-sm border-primary">
					<div class="card-header py-3 text-white bg-primary border-primary">
						<h4 class="my-0 fw-normal">House</h4>
					</div>
					<div class="card-body">
						<h2 class="card-title pricing-card-title">(Earns 2-5 golds)</h2>
						<form action="/process_money" method="post">
							<input type="hidden" name="building" value="house" />
							<button type="submit" class="w-100 btn btn-lg btn-primary">Find
								gold!</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card mb-4 rounded-3 shadow-sm border-primary">
					<div class="card-header py-3 text-white bg-primary border-primary">
						<h4 class="my-0 fw-normal">Casino</h4>
					</div>
					<div class="card-body">
						<h2 class="card-title pricing-card-title">(Earns/takes 0-50
							golds)</h2>
						<form action="/process_money" method="post">
							<input type="hidden" name="building" value="casino" />
							<button type="submit" class="w-100 btn btn-lg btn-primary">Find
								gold!</button>
						</form>
					</div>
				</div>
	</main>

	<div class="row row-cols-1 row-cols-md-1 mb-3 text-center">
		<div class="col">
			<div class="card mb-4 rounded-3 shadow-sm border-primary">
				<div class="card-header py-3 text-white bg-primary border-primary">
				</div>
				<div class="card-body">
					<h4 class="card-title pricing-card-title">Activities:</h4>
					<ul>
					<c:forEach var="activity" items="${activities}">
						<li>
						<c:out value="${activity}" />
						</li>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</div>



</body>
</html>
