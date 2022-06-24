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
		<div>
			<h1>Welcome, ${user.name}</h1>
			<p>Books from everyone's shelves:</p>	
		</div>
		<div>
			<p><a href="/logout">logout</a></p>
			<p><a href="/books/new">+ Add a book to my shelf!</a></p>	
		</div>		
	</div>
	<table>
			<tr>
			   <th>ID</th>
			   <th>Title</th>
			   <th>Author Name</th>
			   <th>Posted By</th>		   
			 </tr>
	<c:forEach var="book" items="${books}"> <!-- "books" matches the modelAttribute in the bookAll method in the controller -->
			 <tr>
			   <td>${book.id}</td>
			   <td><a href="/books/${book.id}">${book.title}</a></td>
			   <td>${book.author}</td>
			   <td>${book.user.name}</td>
			 </tr>		
	</c:forEach>
		</table>	
</body>
</html>