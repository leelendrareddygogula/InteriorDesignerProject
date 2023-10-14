<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer | Details</title>
<jsp:include page="homenavbar.jsp" />
<link rel="stylesheet" href="/css/oC.css">
</head>
<body>
	<br>
	<br/><br/>
		<center>
		<div class="card">
		<h2 style="color: black" align="center">Please Enter Your Details</h2><br/>
			<form action="/customer/quotationGeneration" method="post">
				<table>
					<tr>
						<td>Enter your name:</td>
						<td> <input type="text" name="customerName" required="required" placeholder="enter your name"> </td>
					</tr>
					<tr>
						<td>Your mobile number: </td>
						<td> <input type="number" name="customerMobile" required="required" placeholder="1234567890"> </td>
					</tr>
					<tr>
						<td>Language comfortable with: </td>
						<td> 
							<select name="language" required="required">
								<option value="-1" disabled="disabled" selected="selected">---Select---</option>
								<option value="Telugu">Telugu</option>
								<option value="Hindi">Hindi</option>
								<option value="English">English</option>
							</select>
						</td>
					</tr>
				</table>
				<br>
				<center>
					<button class="generate-continue" type="submit">
						<span class="material-symbols-outlined">
							save
						</span>
						<div style="padding: 5%;">
							Save
						</div>
					</button>
				</center>
			</form>
			<br>
			<center>
					<button class="generate-continue" type="submit" style="background: red;">
					<a href="/customer/quotation/new" style="text-decoration: none; color: white; font-size: 20px;">
						<div style="padding: 5%;">
							Cancel
						</div>
					</a>
					</button>
				</center>
			
		</div>
	</center>
	<a href="/">Home?</a>
</body>
<jsp:include page="footerforall.jsp" />
</html>