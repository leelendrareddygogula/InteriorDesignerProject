<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="homenavbar.jsp" />
<link rel="stylesheet" href="/css/dL.css">
<title>Login</title>
</head>
<body>
	<center>
	<div class="card">
	<h2 align="center">Enter Login Details</h2>
	<h3 style="color: red" align="center"> <c:out value="${msg}"></c:out> </h3>
		<form action="/designer" method="post">
			<table align="center">
				<tr>
					<td>Enter Username:</td>
					<td> <input type="text" required="required" name="username" placeholder="Username Here"> </td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td> <input type="password" required="required" name="password" placeholder="Password Here"> </td>
				</tr>
			</table>
			<br>
			<center>
					<button>Validate</button>
				</center>
		</form>
		</div>
		</center>
</body>
<jsp:include page="footerforall.jsp" />
</html>