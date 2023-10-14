<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/customerDetails.css">
<title>Quotation | Customer Details</title>
</head>
<body>
	<br>
	<center>
		<div class="card">
		<h2 align="center" style="color: black;">Customer Details</h2>
		<br/>
			<form action="/designer/mapCustomer" method="post">
				<table class="com2" align = "center">
					<tr>
						<td>Enter the name of customer</td>
						<td> <input type="text" name="custname" required="required"> </td>
					</tr>
					<tr>
						<td>Enter the contact number of customer</td>
						<td> <input type="number" name="custcontact" required="required"> </td>
					</tr>
					<tr>
						<td>Enter the Address of customer</td>
						<td> <input type="text" name="custaddress" required="required"> </td>
					</tr>
					<tr>
						<td>Enter the PAN/GSTIN of customer</td>
						<td> <input type="text" name="custpan" required="required"> </td>
					</tr>
					<tr>
						<td>Enter the quotationId of customer</td>
						<td> <input type="text" name="quotationid" required="required" value="${quotid}" readonly="readonly"> </td>
					</tr>
					<tr>
						<td>Name of person contacted by customer</td>
						<td> <input type="text" name="contactperson" required="required"> </td>
					</tr>
					<tr>
						<td>Grand Total on Quotation is</td>
						<td> <input type="text" name="grandTotal" required="required" value="${totSum}" readonly="readonly"> </td>
					</tr>
					<tr>
						<td>Please enter the finalized amount:</td>
						<td> <input type="number" name="finalizedTotal" required="required"> </td>
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
					<a href="/designer/newQuotation" style="text-decoration: none; color: white; font-size: 20px;">
						<div style="padding: 5%;">
							Cancel
						</div>
					</a>
					</button>
				</center>
		</div>
	</center>
	<br/><br/>
	<div class="com">
	<h2 align="center", style="color: white">Added Items</h2>
		<table align = "center" style="border: 2px solid white;
    width: 95%;
    font-size: 20px;">
			<tr>
				<th>Component Name</th>
				<th>Height (inches)</th>
				<th>Width (inches)</th>
				<th>Area (Sq.feet)</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Total Amount</th>
			</tr>
			<c:forEach items="${savedquotns}" var="q">
				<tr>
					<td>${q.name}</td>
					<td>${q.height}</td>
					<td>${q.width}</td>
					<td>${q.area}</td>
					<td>${q.price}</td>
					<td>${q.quantity}</td>
					<td>${q.total}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>