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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/material-ui/4.12.4/index.js" integrity="sha512-wEnX3bNd/CdyrOFR0KIGlHihK/w9x3/It8Vc18aymEF/F/f1q0Mq8T+GSxF1wYUACLEGECapuIYQdQlKY1LBJw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div>
		<h1>Add Your Favorite Tea</h1>
		<a href="/teas">back to the teas</a>
	
	</div>
	<form:form action="/teas/add" method="POST" modelAttribute="tea">
		<div>
			<form:label path="name">Tea Name:</form:label>
			<form:input type="text" path="name"></form:input>
			<form:errors class="col_red" path="name"></form:errors>		
		</div>
		<div>
			<form:label path="type">Type:</form:label>
			<form:input type="text" path="type"></form:input>
			<form:errors class="col_red" path="type"></form:errors>		
		</div>
		<div>
			<form:label path="description" for="">description:</form:label>
			<form:textarea path="description" rows="4" cols="30"></form:textarea>
			<form:errors class="col_red" path="description"></form:errors>		
		</div>				
		<div>
			<form:label path="ingredient" for="">Ingredients:</form:label>
			<form:textarea path="ingredient" rows="4" cols="30"></form:textarea>
			<form:errors class="col_red" path="ingredient"></form:errors>		
		</div>
		<input class="align_right" type="submit" value="submit" id="blue-btn"/>
	</form:form>	
</body>
</html>