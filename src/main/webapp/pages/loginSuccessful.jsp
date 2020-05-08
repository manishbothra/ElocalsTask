<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello ${user.firstname}, welcome to ELocals</h1>
	<form action="dummy">
		CLick here to extend your session <input type="submit" value="Extend">
	</form>
	<form action="start">
		CLick here to logout <input type="submit" value="Logout">
	</form>
	
	
</body>
</html>