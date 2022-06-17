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
	<link href="${contextPath}/resource/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<div class="flex">
		<h1>Expense Details</h1>
		<a href="/travel">Go back</a>	
	</div>
	<p>Expense Name: ${travel.name}</p>
	<p>Expense Description: ${travel.description}</p>
	<p>Vendor: ${travel.vendor}</p>
	<p>Amount Spent: ${travel.amount}</p>
	
</body>
</html>