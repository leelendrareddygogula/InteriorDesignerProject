<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/quotationImages.css">
<jsp:include page="navbarforadmin.jsp" />
<title>Billing | New</title>
</head>
<body>
	
	<center>
	<div class="card">
	<h2 align="center">Add Bill Components</h2>
		<form action="/designer/addBillComponent" method="post">
			<table align = "center">
				<tr>
					<td>Description: </td>
					<td> <input type="text" name="billCompName" required="required" placeholder="enter name here"> </td>
				</tr>
				<tr>
					<td>Enter Price: </td>
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
	</div>
	</center>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>