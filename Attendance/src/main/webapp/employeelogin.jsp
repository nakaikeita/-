<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style2.css">
</head>
<body style="background-color:azure;">
	<h1><br></h1>
	<div class="login-box">
	<form action="Employee-login-servlet" method="post">
		<p class="login">従業員ログイン</p>
		<input type="text" name="userId" placeholder="ID" required><br>
		<input type="password" name="password" placeholder="password" required><br><br>
		<input type="submit" value="ログイン" class="login-submit">	
		<% 
			String errorMsg = (String)request.getAttribute("errorMsg");
			if (errorMsg != null) {
		%>
			<p class="error-msg"><%= errorMsg %></p>
		<%
			} 
		%>
	</form>
	</div>
</body>
</html>
