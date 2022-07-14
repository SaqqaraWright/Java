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
	<div class="navbar flex">
		<img src="/img/4.png" alt="tea time logo" class="logo-img">
		<a href="/teas">back to the teas</a>	
	</div>	
	<h3>${tea.name}</h3>	
	<div>
		<p> Type: ${tea.type}</p>
		<p>Description: ${tea.description}</p>
		<p>Ingredients: ${tea.ingredient}</p>
		<p>Rating: ${tea.calcRating()}</p>	
	</div>
	<c:if test="${tea.user.id == user.id}"> <!-- this allows for only users who created a particular entry to be able to edit or delete it. -->
		<a href="/teas/${tea.id}/edit">Edit</a>
		<form action="/teas/delete/${tea.id}" method="POST">
			<input type="submit" value="delete" id="red-btn" />
	    </form>	
	</c:if>
</body>
</html>