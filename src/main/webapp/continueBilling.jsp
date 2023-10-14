<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Billing | Continue</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/cB.css">
</head>
<body>
	<br><br>
	
	<br>
	<div class="details">
	<h2 align="center" style="color: white">Added Components </h2>
	<table align = "center">
		<tr>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${availableComponents}" var="b">
			<tr>
				<td>${b.componentName}</td>
				<td>${b.amount}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<center>
	<div class="buttons-dis">
		<button class="opt-buttons1"><a href="/designer/generateBill">Clear All</a></button>
		<button class="opt-buttons2"><a href="/designer/saveBilling">Save Bill</a></button>
	</div>
	</center>
	</div>
	
	<center>
		<div class="card">
		<h2 align="center">To Continue </h2>
			<form action="/designer/addBillComponent" method="post">
				<table align = "center">
					<tr>
						<td>Description</td>
						<td> <input type="text" name="billCompName" required="required" placeholder="enter name here"> </td>
					</tr>
					<tr>
						<td>Enter Price</td>
						<td> <input type="number" name="billCompPrice" required="required" placeholder="enter amount"> </td>
					</tr>
				</table>
				<br>
				<center>
				<button class="generate-continue" type="submit">
					<span class="material-symbols-outlined">
						receipt_long
					</span>
					<div style="padding: 5%;">
						Continue
					</div>
				</button>
			</center>
			</form>
			<br>
		</div>
	</center>
	<br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>