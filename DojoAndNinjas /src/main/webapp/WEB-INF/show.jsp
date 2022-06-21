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
	<h1>${dojo.name} Location Ninjas</h1>
	<table>
			<tr>
			   <th>First Name</th>
			   <th>Last Name</th>
			   <th>Age</th>		   
			 </tr>
	<c:forEach var="oneNinja" items="${dojo.ninjas}"> <!-- Note: dojo is attached to ninjas because dojo has ninjas... var="ninja" is the iterator and ${ninjas} is the object to be iterated, in this case the array list to be iterated. Note: "items"= is always called "items". -->
			 <tr>
			   <td>${oneNinja.firstName}</td>
			   <td>${oneNinja.lastName}</td>
			   <td>${oneNinja.age}</td>
			 </tr>		
	</c:forEach>
		</table>	
</body>
</html>
