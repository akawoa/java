<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${event.name}"/></title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- For linking bootstrap CSS to page -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/pricing/">
</head>
<body>
<h1><c:out value="${event.name}"/></h1>
<p>Date: <fmt:formatDate pattern="MMMM-dd-yyyy" value = "${event.eventDate}" /></p>
<p>Location: <c:out value="${event.location}"/></p>
<p>Host: <c:out value="${event.user.firstName}"/></p>
<a href="/events/${event.id}/edit">Edit Event</a>
<form action="/events/${event.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form><br><br><br><br>

<p>Number of Attendees: <c:out value="${event.getUsersAttending().size()}" /></p>
                 <table class="table table-bordered">
                 <thead>
                 <tr>
                 <th scope="col">Name</th>
                 <th scope="col">From</th>
                 </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${event.getUsersAttending()}" var="singleAttendee">
                 	<tr>
						<td><c:out value="${singleAttendee.firstName}" /> <c:out value="${singleAttendee.lastName}" /></td>
						<td><c:out value="${singleAttendee.location}" />, <c:out value="${singleAttendee.state}" /></td>
	                 </tr>
	             </c:forEach>
                 </tbody>
                 </table>

<a href="/events">Home</a>

</body>
</html>