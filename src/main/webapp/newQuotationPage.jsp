<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/newQuotationPage.css">
<title>Quotation | New</title>
</head>
<body>
	<br>
	<br>
	<center>
		<div class="card">
		<h2 align="center">Generate New Quotation</h2><br/>
			<form action="/designer/addComponent" method="post">
				<table align = "center">
					<tr>
						<td> Enter the description: </td>
						<td> <input type="text" name="componentname" required="required" > </td>
					<tr>
					<tr>
						<td> Enter the height (in inches): </td>
						<td> <input type="number" name="height" required="required" placeholder="-1 if not applicable"> </td>
					<tr>
					<tr>
						<td> Enter the width (in inches): </td>
						<td> <input type="number" name="width" required="required" placeholder="-1 if not applicable"> </td>
					<tr>
					<tr>
						<td> Enter the quantity: </td>
						<td> <input type="number" name="quantity" required="required" > </td>
					<tr>
					<tr>
						<td> Enter the price (in rupees): </td>
						<td> <input type="number" name="price" required="required" > </td>
					<tr>
					<tr>
						<td colspan="2" align="center">
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
						</td>
					</tr>
				</table>
			</form>
		</div>
	</center>
	
	
	<br><br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>