<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Super User</title>
<style type="text/css">

div {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #D6CC99;
  padding: 3%;
  border-radius: 5%;
  width: 50%;
  height: 50%;
}

</style>
</head>
<body>
	<h1 align="center" style="color: chocolate;">Super User Home</h1>
	<hr color="black"/><hr color="black"/> 
	
	<div>
		<h2 align="center">Add Admin</h2>
		<h3 style="color: blue" align="center"> <c:out value="${msg}"></c:out> </h3>
		<form action="/superuser/add/admin" method="post">
			<table align = "center">
				<tr>
					<td>Enter username of super admin: </td>
					<td><input type="text" name="superadminuname" required="required"> </td>
				</tr>
				<tr>
					<td>Enter password of super admin: </td>
					<td><input type="password" name="superadminpwd" required> </td>
				</tr>
				<tr>
					<td>Enter username of new admin: </td>
					<td><input type="text" name="newadminuname" required="required"> </td>
				</tr>
				<tr>
					<td>Enter password of new admin: </td>
					<td><input type="password" name="newadminpwd" required="required"> </td>
				</tr>
				<tr align="center">
					<td colspan="2">
						<button>Add</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
</body>
</html>