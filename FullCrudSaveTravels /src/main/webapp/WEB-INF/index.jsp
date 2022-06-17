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
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet"><!-- this is supposed to allow me to use bootstrap but it doesn't seem to be working -->
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>Save Travels</h1>
		<table>
			<tr>
			   <th>Expense</th>
			   <th>Vendor</th>
			   <th>Amount</th>
			   <th>Actions</th>			   
			 </tr>
	<c:forEach var="travel" items="${travels}"> <!-- var="travel" is the iterator and ${travels} is the object to be iterated, in this case the array list to be iterated. Note: "items"= is always called "items". -->
			 <tr>
			   <td><a href="/travel/show/${travel.id}">${travel.name}</a></td>
			   <td>${travel.vendor}</td>
			   <td>${travel.amount}</td>
			   <td class="flex">
			   	<a href="/travel/edit/${travel.id}">edit</a>
			   	<form action="/travel/delete/${travel.id}" method="POST">
			   	<input type="submit" value="delete" id="red-btn" />
			   	</form>
			   	</td>
			 </tr>		
	</c:forEach>
		</table>	




	<h3>Add An Expense</h3>
	
	<form:form action="/travel" method="POST" modelAttribute="travel">
		<div>
			<form:label for="" path="name">Expense Name:</form:label>
			<form:input type="text" path="name"></form:input> 
			<form:errors path="name" class="col_red"></form:errors>		
		</div>
		<div>
			<form:label for="" path="vendor">Vendor:</form:label>
			<form:input type="text" path="vendor"></form:input> 
			<form:errors path="vendor" class="col_red"></form:errors>		
		</div>
		<div>
			<form:label for="" path="amount">Amount:</form:label>
			<form:input type="number" path="amount"></form:input> 
			<form:errors path="amount" class="col_red"></form:errors>		
		</div>
		<div>
			<form:label for="" path="description">Description:</form:label>
			<form:textarea rows="4" cols="20" path="description"></form:textarea> 
			<form:errors path="description" class="col_red"></form:errors>		
		</div>		
		<input type="submit" value="Submit" id="blue-btn" />	
	</form:form>
</body>
</html>