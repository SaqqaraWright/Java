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
<h1 class="text_center">Here's Your Omikuji!</h1>
<div class="border_1 bg_blue">
<p>In ${number} years, you will live in ${city} with ${name} as your roommate, selling
 ${hobby} for a living.</p>
 <p>The next time you see a ${thing}, you will have good luck.</p>
 <p>Also, ${compliment}</p>
</div>
<br>
<a href="/">Go Back</a>

</body>
</html>