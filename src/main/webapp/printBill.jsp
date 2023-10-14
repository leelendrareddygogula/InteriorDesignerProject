<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAMS TROVE - Billing</title>
<link rel="stylesheet" href="/css/printQuotation.css">
</head>
<body>
	<h1 style="color: #a57c3e" align="center">VAMS TROVE</h1>
	<p align="center">
Flat no-2-1, Mouli Towers, 2nd Floor, 1st Block, 40-14-10E, Chandra Mouli Puram,</p>
<p align="center"> Benz Circle, Vijayawada, Andhra Pradesh 520010</p>
<p align="center"><b>GSTIN: 37ACCFA4901C1ZZ</b></p>
	<hr color="black"/>
	
	<h2 align="center">Billing</h2>
	<br/><br/>
	
	<div class="alltables">
		<table align = "center">
		<tr>
			<td><b>Bill Id: </b></td>
			<td>${billDetail.billId}</td>
		</tr>
		<tr>
			<td><b>Name: </b></td>
			<td>${billDetail.customerName}</td>
		</tr>
		<tr>
			<td><b>Date of Billing: </b></td>
			<td>${billDetail.billDate}</td>
		</tr>
	</table>
	
	<table align = "center">
		<tr>
			<td>.</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Quotation Id: </b></td>
			<td>${billDetail.quotationId}</td>
		</tr>
		<tr>
			<td><b>Billing Method: </b></td>
			<td>${billDetail.billingMethod}</td>
		</tr>
	</table>
	
	</div>
	
	<br/><br/><br/>
	
	<table class="displaytable" align = "center" border="2">
		<tr>
			<th>Description</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${billComponents}" var="bill">
			<tr>
				<td>${bill.componentName}</td>
				<td>${bill.amount}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div class="container">
		<div class="sign1" align="center">
		<table align = "center">
			<tr>
				<td><b>Total Price:</b></td>
				<td>Rs. ${billDetail.totalPrice}</td>
			</tr>
			<tr>
				<td><b>GST Percentage:</b></td>
				<td>${billDetail.gstPercentage} %</td>
			</tr>
			<tr>
				<td><b>Total Amount:</b></td>
				<td>Rs. ${billDetail.totalAmount}</td>
			</tr>
		</table>
	</div>
	
	<div class="sign2">
		<h3>__________________</h3>
		<p>Authorized Signature</p>
	</div>
	</div>
	<br>
	<div align="center">
		<button class="printbutton" onclick="window.print()">Print</button>
	</div>
</body>
</html>