<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VAMS TROVE - Furniture</title>
<link rel="stylesheet" href="/css/printQuotation.css">
</head>
<body>

<h1 style="color: #a57c3e" align="center">VAMS TROVE</h1>
	<p align="center">
Flat no-2-1, Mouli Towers, 2nd Floor, 1st Block, 40-14-10E, Chandra Mouli Puram,</p>
<p align="center"> Benz Circle, Vijayawada, Andhra Pradesh 520010</p>
<p align="center"><b>GSTIN: 37ACCFA4901C1ZZ</b></p>
	<hr color="black"/>
	<h2 align="center">Furniture Quotation</h2>
	<div class="idalign">
		
		<div class="alltables">
	<table align = "center">
		<tr>
			<td><b>Quotation ID:</b></td>
			<td>${summaryRecord.id}</td>
		</tr>
		<tr>
			<td><b>Customer Name: </b></td>
			<td>${summaryRecord.name}</td>
		</tr>
		<tr>
			<td><b>Customer Address: </b></td>
			<td>${summaryRecord.address}</td>
		</tr>
		<tr>
			<td><b>Customer Contact: </b></td>
			<td>${summaryRecord.contactNumber}</td>
		</tr>
	</table>
	
	<table align = "center">
		<tr>
			<td>.</td>
			<td></td>
		</tr>
		<tr>
			<td><b>Date: </b></td>
			<td>${summaryRecord.date}</td>
		</tr>
		<tr>
			<td><b>Customer PAN/GSTIN: </b></td>
			<td>${summaryRecord.panOrGstin}</td>
		</tr>
		<tr>
			<td><b>Contact Person: </b></td>
			<td>${summaryRecord.contactPerson}</td>
		</tr>
	</table>
	</div></div>
	<br/><br/>
	<table class="displaytable" align = "center">
		<tr align="center">
			<th style="width: auto;">Image</th>
			<th>Reference</th>
			<th style="width: auto;">Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th style="width: 15%;">Amount</th>
		</tr>
		<c:forEach items="${quotationTuples}" var="item">
			<tr>
				<td>
					<img src="/designer/viewImportImage/${item.importreference}" width="40%" height="25%">
				</td>
				<td>${item.importreference}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.quantity}</td>
				<td>${item.amount}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right"><b>Estimated Total: </b></td>
			<td>Rs. ${summaryRecord.calculatedAmount}</td>
		</tr>
		<tr>
			<td colspan="5" align="right"><b>Finalized Total: </b></td>
			<td>Rs. ${summaryRecord.finalizedAmount}</td>
		</tr>
	</table>
	
	<div class="sign">
		<h3>__________________</h3>
		<p>Authorized Signature</p>
	</div>
	
	<h3 class="printbutton" align="center"><input type="button" onclick="window.print()" value="Print"></h3>
	
</body>
</html>