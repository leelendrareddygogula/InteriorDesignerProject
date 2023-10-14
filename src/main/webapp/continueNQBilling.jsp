<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>External Billing | Continue</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/newNQBill.css">
<link rel="stylesheet" href="/css/cB.css">
</head>
<body>
	<br>
	
	<center>
	<div class="details">
	<h2 align="center" style="color: white">Already Added</h2>
		<table align="center" border="1">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${addedComponents}" var="bill">
				<tr>
					<td>${bill.name}</td>
					<td>${bill.amount}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
			<center>
				<div class="buttons-dis">
					<button class="opt-buttons1"><a href="/designer/nonQuotationBill">Clear All</a></button>
					<button class="opt-buttons2"><a href="/designer/saveNQbill">Save Bill</a></button>
				</div>
			</center>
	</div>
	</center>
	<br/><br/>
	
	<center>
	
	<div class="card">
	<h2 align="center">Please Continue</h2>
		<form action="/designer/addNQBillComponent" method="post">
			<table align="center">
				<tr>
					<td>Enter name: </td>
					<td> <input type="text" required="required" name = "nqbillcompname"> </td>
				</tr>
				<tr>
					<td>Enter price: </td>
					<td> <input type="number" required="required" name = "nqbillcompvalue"> </td>
				</tr>
			</table>
			
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
	<br/><br/>
	<br/><br/>
</body>
<jsp:include page="footerforall.jsp" />
</html>