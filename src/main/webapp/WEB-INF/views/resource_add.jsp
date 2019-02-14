<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			<h2>Resource</h2>
		</div>
		<spring:url value="/resource/save" var="formUrl"/>
		<form:form action="${formUrl}" method="POST" modelAttribute="resource">
			<div class="row">
				<div class="form-group">
					<label for="resource-name">Name</label>
					<form:input path="name" cssClass="form-control" id="resource-name"/>
				</div>
				<div class="form-group">
					<label for="type">Type</label>
					<form:select path="type" items="${options}" cssClass="form-control" id="type"/>
				</div>
				<div class="form-group">
					<label for="cost">Cost</label><input type="text"
						id="cost" class="form-control" name="cost" />
				</div>
				<div class="form-group">
					<label for="unit-of-measure">Unit Of Measure</label>
					<form:radiobuttons path="unitOfMeasure" items="${radios}" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label for="indicators">Indicators</label>
					<form:checkboxes path="indicators" items="${checks}" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<label for="notes">Notes</label>
					<form:textarea path="notes" cssClass="form-control" rows="3" id="notes"/>
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>