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
	<div class="flex">
		<h1>${book.title}</h1>
		<a href="/books">back to the shelves</a>	
	</div>
	<h5><strong><span class="col_red">${book.user.name}</span> read <span class="col_purple">${book.title}</span> by <span class="col_green">${book.author}</span>.</strong></h5>
	<h5>Here are ${book.user.name}'s thoughts:</h5>
	<hr />
		<p>${book.description}</p> 
	<hr />
	<a href="/books/${book.id}/edit">edit</a> <!-- this should only show if user added book -->
</body>
</html>
