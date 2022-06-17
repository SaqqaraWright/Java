<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div class="flex">
		<h1>Edit Expense</h1>
		<a href="/travel">Go back</a>
	
	</div>
	
	<form:form action="/travel/edit/${travel.id }" method="POST" modelAttribute="travel">
		<div>
			<form:label for="" path="name">Expense Name:</form:label>
			<form:input type="text" path="name"></form:input> 
			<form:errors path="name" class="col_red"></form:errors>		
		</div>
		<div>
			<form:label for="" path="vendor">Vendor:</form:label>
			<form:input type="text" path="vendor"></form:input> 
			<form:errors path="vendor" class="col_red"></form:errors>		
		</div>
		<div>
			<form:label for="" path="amount">Amount:</form:label>
			<form:input type="number" path="amount"></form:input> 
			<form:errors path="amount" class="col_red"></form:errors>		
		</div>
		<div>
			<form:label for="" path="description">Description:</form:label>
			<form:textarea rows="4" cols="20" path="description"></form:textarea> 
			<form:errors path="description" class="col_red"></form:errors>		
		</div>		
		<input type="submit" value="Submit" id="blue-btn" />	
	</form:form>
</body>
</html>