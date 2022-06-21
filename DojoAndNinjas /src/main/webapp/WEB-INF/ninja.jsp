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
	<h1>New Ninja</h1>
	
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
		<div>
			<form:label for="" path="dojo">Dojo:</form:label>
			<form:select type="text" path="dojo"> 
				<c:forEach var="oneDojo" items="${ dojo }">
					<form:option value="${ oneDojo.id }">${ oneDojo.name }</form:option>				
				</c:forEach>			
			</form:select>
			<form:errors class="col_red" path="dojo"></form:errors>			
		</div>	
		<div>
			<form:label for="" path="firstName">First Name</form:label>
			<form:input type="text" path="firstName"></form:input>
			<form:errors class="col_red" path="firstName"></form:errors>	
		</div>
		<div>
			<form:label for="" path="lastName">Last Name</form:label>
			<form:input type="text" path="lastName"></form:input>
			<form:errors class="col_red" path="lastName"></form:errors>	
		</div>
		<div>
			<form:label for="" path="age">Age</form:label>
			<form:input type="number" path="age"></form:input>
			<form:errors class="col_red" path="age"></form:errors>	
		</div>
		<input type="submit" value="Create" id="blue-btn" />
	
	</form:form>
</body>
</html>
