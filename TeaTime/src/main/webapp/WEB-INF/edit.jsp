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
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div>
		<h1>Edit Your Tea</h1>
		<a href="/teas">back to the teas</a>
	
	</div>
	<form:form action="/teas/${tea.id}/edit" method="POST" modelAttribute="tea">
		<div>
			<form:errors class="col_red" path="name"></form:errors>		
			<form:label path="name">Tea Name:</form:label>
			<form:input type="text" path="name"></form:input>
		</div>
		<div>
			<form:errors class="col_red" path="type"></form:errors>		
			<form:label path="type">Type:</form:label>
			<form:input type="text" path="type"></form:input>
		</div>
		<div>
			<form:errors class="col_red" path="description"></form:errors>		
			<form:label path="description" for="">Description:</form:label>
			<form:textarea type="text" path="description" rows="4" cols="30"></form:textarea>
		</div>				
		<div>
			<form:errors class="col_red" path="ingredient"></form:errors>		
			<form:label path="ingredient">Ingredients:</form:label>
			<form:textarea type="text" path="ingredient" rows="4" cols="30"></form:textarea>
		</div>
		<input class="align_right" type="submit" value="submit" id="blue-btn"/>
	</form:form>	
</body>
</html>