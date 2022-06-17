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
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1 class="text_center">Send an Omikuji!</h1>
	<form class="grid gap1" action="/submit" method="POST" >
	<div>
		<label for="html">Pick any number from 5 - 25:</label>
		<input type="number" name="number" />
	</div>
	<div>
		<label for="html">Enter the name of any city.</label>
		<input type="text" name="city" />
	</div>
	<div>
		<label for="html">Enter the name of any real person.</label>
		<input type="text" name="name" />
	</div>
	<div>
		<label for="html">Enter professional endeavor or hobby.</label>
		<input type="text" name="hobby" />
	</div>
	<div>
		<label for="html">Enter any type of living thing.</label>
		<input type="text" name="thing" />
	</div>
	<div>
		<label for="html">Say something nice to someone.</label>
		<textarea name="compliment" rows="4" cols="20"></textarea> <!-- "id=" was included in this. bring back if needed -->
	</div>
	<br>
	<p>Send and show a friend:-)</p>
	<input type="Submit" value="Send" />
	
	</form>
</body>
</html>