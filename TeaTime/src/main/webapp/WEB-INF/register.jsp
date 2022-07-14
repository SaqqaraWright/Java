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
	<div class="navbar">
		<img src="/img/4.png" alt="tea time logo" class="logo-img">
	</div>
	<div>
		<h2 class="text_center">Register</h2>
		<form:form action="/register" method="POST" modelAttribute="userRegister">
			<div>
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name"></form:input>
			<form:errors class="col_red" path="name"></form:errors>		
			</div>
			<div>
			<form:label path="email">Email:</form:label>
			<form:input type="text" path="email"></form:input>
			<form:errors class="col_red" path="email"></form:errors>		
			</div>
			<div>
			<form:label path="password">Password:</form:label>
			<form:input type="password" path="password"></form:input>
			<form:errors class="col_red" path="password"></form:errors>		
			</div>
			<div>
			<form:label path="confirm">Confirm Password:</form:label>
			<form:input type="password" path="confirm"></form:input>
			<form:errors class="col_red" path="confirm"></form:errors>		
			</div>		
			<p>Already have an account? <a href="/login">Click here to login</a></p>
			<input type="submit" value="submit" id="blue-btn"/>
		</form:form>	
	</div>
</body>
</html>