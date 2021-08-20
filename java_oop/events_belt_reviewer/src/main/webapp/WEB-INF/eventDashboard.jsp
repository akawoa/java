<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
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
	<title>Welcome</title>
</head>
<body>
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-6">
			<ul class="nav">
				<li class="nav-item"><a class="nav-link active" href="/events">Home</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
			</ul>
		</div>
			<h1>Welcome, <c:out value="${user.firstName}"/> from <c:out value="${user.state}"/></h1><br><br><br><br>
			<h2>Here is a list of upcoming events in your state:</h2><br><br><br><br>
<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>Host</th>
							<th>Action / Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${events}" var="event">
							<c:if test="${event.state == user.state}">
							<tr>
								<td><a href="/events/${event.id}"><c:out
											value="${event.name}" /></a></td>
      <td><fmt:formatDate pattern="MMMM-dd-yyyy" value = "${event.eventDate}" /></td>
								<td><c:out value="${event.location}" /></td>
								<td><c:out value="${event.user.firstName}" /></td>
								<td>
								<c:if test="${user_id != event.user.id}" >
								<c:choose>
								<c:when test="${event.getUsersAttending().contains(user)}">									
								<p>Joining | <a href="/events/${event.id}/cancel">Cancel</a></p>					
								</c:when>								
								<c:otherwise>
								<a href="/events/${event.id}/attend">Join</a>
								</c:otherwise>
								</c:choose>								
								</c:if>								
								<c:if test="${user_id == event.user.id}" >
								<a href="/events/${event.id}/edit">Edit</a>
								 | <a href="/events/${event.id}/delete">Delete</a>
								 </c:if>
								 </td>
							<tr>	
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div><br><br><br><br><br><br><br><br>
	<h2>Here is a list of upcoming events occurring outside of ${user.state}:</h2><br><br><br><br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>State</th>
							<th>Host</th>
							<th>Action / Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${events}" var="event">
							<c:if test="${event.state != user.state}">
							<tr>
								<td><a href="/events/${event.id}"><c:out
											value="${event.name}" /></a></td>
      <td><fmt:formatDate pattern="MMMM-dd-yyyy" value = "${event.eventDate}" /></td>
								<td><c:out value="${event.location}" /></td>
								<td><c:out value="${event.state}" /></td>
								<td><c:out value="${event.user.firstName}" /></td>
								<td>
								<c:if test="${user_id != event.user.id}" >
								<c:choose>
								<c:when test="${event.getUsersAttending().contains(user)}">									
								<p>Joining | <a href="/events/${event.id}/cancel">Cancel</a></p>						
								</c:when>								
								<c:otherwise>
								<a href="/events/${event.id}/attend">Join</a>
								</c:otherwise>
								</c:choose>
								</c:if>
								<c:if test="${user_id == event.user.id}" >
								<a href="/events/${event.id}/edit">Edit</a>
								 | <a href="/events/${event.id}/delete">Delete</a>
								 </c:if>
								 </td>
							<tr>	
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div><br><br><br><br><br><br><br><br>

	<div class="container">
		<h2>Create an Event</h2>
		<form:form action="/events/new" method="post" modelAttribute="eventObj">
		<form:input value="${user_id}" path="user" type="hidden" />
			<p>
				<form:label path="name">Name</form:label>
				<form:input type="text" path="name"/>
			</p>
						<p>
				<form:label path="eventDate">Date</form:label>
				<form:input type="date" path="eventDate"/>
			</p>
			<p>
				<form:label path="location">Location</form:label>
				<form:input type="text" path="location"/>
			</p>
			<p>
				<form:label path="state">State</form:label>
				<form:select path="state">
    				<option value="">Select a State</option>
    				<option value="AL">AL</option>
					<option value="AK">AK</option>
					<option value="AR">AR</option>	
					<option value="AZ">AZ</option>
					<option value="CA">CA</option>
					<option value="CO">CO</option>
					<option value="CT">CT</option>
					<option value="DC">DC</option>
					<option value="DE">DE</option>
					<option value="FL">FL</option>
					<option value="GA">GA</option>
					<option value="HI">HI</option>
					<option value="IA">IA</option>	
					<option value="ID">ID</option>
					<option value="IL">IL</option>
					<option value="IN">IN</option>
					<option value="KS">KS</option>
					<option value="KY">KY</option>
					<option value="LA">LA</option>
					<option value="MA">MA</option>
					<option value="MD">MD</option>
					<option value="ME">ME</option>
					<option value="MI">MI</option>
					<option value="MN">MN</option>
					<option value="MO">MO</option>	
					<option value="MS">MS</option>
					<option value="MT">MT</option>
					<option value="NC">NC</option>	
					<option value="NE">NE</option>
					<option value="NH">NH</option>
					<option value="NJ">NJ</option>
					<option value="NM">NM</option>			
					<option value="NV">NV</option>
					<option value="NY">NY</option>
					<option value="ND">ND</option>
					<option value="OH">OH</option>
					<option value="OK">OK</option>
					<option value="OR">OR</option>
					<option value="PA">PA</option>
					<option value="RI">RI</option>
					<option value="SC">SC</option>
					<option value="SD">SD</option>
					<option value="TN">TN</option>
					<option value="TX">TX</option>
					<option value="UT">UT</option>
					<option value="VT">VT</option>
					<option value="VA">VA</option>
					<option value="WA">WA</option>
					<option value="WI">WI</option>	
					<option value="WV">WV</option>
					<option value="WY">WY</option>
				</form:select>	            
	        </p>
			
			<button type="submit">Create</button>
		</form:form>
	</div><br><br><br><br>
		<p><form:errors path="eventObj.*" class="text-danger"/></p>
</body>
</html>