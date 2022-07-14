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
	<title></title> <!-- material ui link below post in rest of pages -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/material-ui/4.12.4/index.js" integrity="sha512-wEnX3bNd/CdyrOFR0KIGlHihK/w9x3/It8Vc18aymEF/F/f1q0Mq8T+GSxF1wYUACLEGECapuIYQdQlKY1LBJw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/main.js"></script>
</head>
<body>
	<div class="flex">
		<div>
			<h1>Hey, ${user.name}</h1>
			<p>Everyone's favorite teas:</p>	
		</div>
		<div>
			<p><a href="/logout">logout</a></p>
			<p><a href="/teas/add">+ Add a new tea to your collection</a></p>	
		</div>		
	</div>
	<table>
		<tr>
		   <th>Tea</th>
		   <th>Type</th>
		   <th>Description</th>
		   <th>Posted By</th>
		   <th>Rating</th>		   
		 </tr>
<c:forEach var="tea" items="${teas}"> <!-- "teas" matches the modelAttribute in the teaAll method in the controller -->
		 <tr>
		   <td><a href="/teas/${tea.id}">${tea.name}</a></td>
		   <td>${tea.type}</td>
		   <td>${tea.description}</td>
		   <td>${tea.user.name}</td>
		   <td>${tea.calcRating()}</td> 
		 </tr>		
</c:forEach>
	</table>
	<hr />
	<h5>Rate Your favorite Tea!</h5>
	<form:form action="/teas/rate" method="POST" modelAttribute="rating"> <!-- something seems a bit off here, may have to create rating controller, want to add rating to tea -->
		<div>
			<form:label for="" path="tea">Tea Name:</form:label>
			<form:select  path="tea"> 
				<c:forEach var="oneTea" items="${ teas }">
					<form:option value="${ oneTea.id }">${ oneTea.name }</form:option>				
				</c:forEach>			
			</form:select>
			<form:errors class="col_red" path="tea"></form:errors>			
		</div>	
		<div>
			<form:label for="" path="rating">Tea Rating:</form:label>
			<form:select  path="rating"> 
				<form:option value="1">1</form:option>	
				<form:option value="2">2</form:option>	
				<form:option value="3">3</form:option>	
				<form:option value="4">4</form:option>	
				<form:option value="5">5</form:option>		
			</form:select>
			<form:errors class="col_red" path="rating"></form:errors>			
		</div>	
		<form:input type="hidden" value="${user.id}" path="user"/>
		<input type="submit" value="Add Rating" id="blue-btn" />
	</form:form>
			
</body>
</html>