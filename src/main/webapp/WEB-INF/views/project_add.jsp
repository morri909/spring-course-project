<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../views/fragments/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<spring:url value="/project/add" var="formUrl"/>
			<form:form modelAttribute="project" action="${formUrl}" method="POST" cssClass="col-md-8 col-md-offset-2">
				<div class="form-group">
					<label for="project-name">Name</label>
					<input type="text" id="project-name"
							class="form-control" name="name"/>
					<form:errors path="name"/>
				</div>
				<div class="form-group">
					<label for="type">Type</label>
					<form:select path="type" cssClass="form-control" items="${types}"/>
				</div>
				<div class="form-group">
					<label for="sponsor">Sponsor Name</label>
					<form:input id="sponsor-name" cssClass="form-control" path="sponsor.name"/>
				</div>
				<div class="form-group">
					<label for="sponsor-phone">Sponsor Phone</label>
					<form:input id="sponsor-phone" cssClass="form-control" path="sponsor.phone"/>
				</div>
				<div class="form-group">
					<label for="sponsor-email">Sponsor Email</label>
					<form:input id="sponsor-email" cssClass="form-control" path="sponsor.email"/>
				</div>
				<div class="form-group">
					<label for="authorizedFunds">Authorized Funds</label>
					<form:input id="funds" cssClass="form-control" path="authorizedFunds"/>
				</div>
				<div class="form-group">
					<label for="startDate">Start Date (Julian)</label>
					<form:input id="startDate" cssClass="form-control" path="startDate"/>
				</div>
				<div class="form-group">
					<label for="authorizedHours">Authorized Hours</label>
					<form:input id="hours" cssClass="form-control" path="authorizedHours"/>
				</div>
				<div class="form-group">
					<label for="description">Description</label>
					<form:textarea cssClass="form-control" rows="3" path="description"/>
					<form:errors path="description"/>
				</div>
				<div class="form-group">
					<label for="special">Special</label>
					<form:checkbox id="special" cssClass="form-control" path="special"/>
				</div>
				<div class="form-group">
					<label for="poc">POC</label>
					<form:input id="poc" cssClass="form-control" path="pointsOfContact[0]"/>
				</div>
				<div class="form-group">
					<label for="poc2">POC2</label>
					<form:input id="poc2" cssClass="form-control" path="pointsOfContact[1]"/>
				</div>
				<div class="form-group">
					<label for="poc3">POC3</label>
					<form:input id="poc3" cssClass="form-control" path="pointsOfContact[2]"/>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>

</body>
</html>