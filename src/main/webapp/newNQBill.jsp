<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/newNQBill.css">
<title>External Billing | New</title>
</head>
<body>
	<br></br>
	<center>
		<div class="card">
		<h2 align="center">Start Your Bill</h2>
			<form action="/designer/addNQBillComponent" method="post">
				<table align="center">
					<tr>
						<td><b>Enter description: </b></td>
						<td> <input type="text" required="required" name = "nqbillcompname" placeholder="description"> </td>
					</tr>
					<tr>
						<td><b>Enter price: </b></td>
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
		</div>
	</center>
	<br><br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>