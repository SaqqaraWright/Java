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
		<h1>Change Your Entry</h1>
		<a href="/books">back to the shelves</a>
	
	</div>
	<form:form action="/books/${book.id}/edit" method="POST" modelAttribute="book">
		<div>
			<form:errors class="col_red" path="title"></form:errors>		
			<form:label path="title">Title</form:label>
			<form:input type="text" path="title"></form:input>
		</div>
		<div>
			<form:errors class="col_red" path="author"></form:errors>		
			<form:label path="author">Author:</form:label>
			<form:input type="text" path="author"></form:input>
		</div>
		<div>
			<form:errors class="col_red" path="description"></form:errors>		
			<form:label path="description" for="">My Thoughts</form:label>
			<form:textarea path="description" rows="4" cols="30"></form:textarea>
		</div>			
		<input class="align_right" type="submit" value="submit" id="blue-btn"/>
	</form:form>	
</body>
</html>
