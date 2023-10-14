<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAMS TROVE - External Billing</title>
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
	<h4 align="center"></h4>
	<h4 align="center"></h4>
	<h4 align="center">
		
	</h4>
	<br/><br/>
	
	<div class="alltables">
		<table align = "center">
		<tr>
			<td><b>Bill Id:</b></td>
			<td> ${billSummary.id}</td>
		</tr>
		<tr>
			<td><b>Customer Name: </b></td>
			<td>${billSummary.customerName}</td>
		</tr>
		<tr>
			<td><b>Date: </b></td>
			<td> ${billSummary.billDate}</td>
		</tr>
		
		<c:if test="${billSummary.refferedBy != ''}">
		<tr>
			<td><b>Contacted By: </b></td>
			<td> ${billSummary.refferedBy}</td>
		</tr>
		</c:if>
		</table>
		
		<table align = "center">
		<tr>
			<td>.</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Mobile Number: </b></td>
			<td> ${billSummary.mobileNumber}</td>
		</tr>
		<tr>
			<td><b>Payment Method: </b></td>
			<td>${billSummary.billingMethod}</td>
		</tr>
		
		
		<c:if test="${billSummary.panOrGstin != ''}">
		<tr>
			<td><b>PAN/GSTIN: </b></td>
			<td> ${billSummary.panOrGstin}</td>
		</tr>
		</c:if>
		
		</table>
		
		</div>
	
	<br><br>
	<table class="displaytable" align="center" border="2">
		<tr>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${billsList}" var="bill">
			<tr>
				<td>${bill.name}</td>
				<td>${bill.amount}</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/>
	
	<div class="container">
		<div class="sign1" align="center">
		<table align = "center">
			<tr>
				<td><b>Total Price:</b></td>
				<td>Rs. ${billSummary.price}</td>
			</tr>
			<tr>
				<td><b>GST Percentage:</b></td>
				<td>${billSummary.gst} %</td>
			</tr>
			<tr>
				<td><b>Total Amount:</b></td>
				<td>Rs. ${billSummary.amount}</td>
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