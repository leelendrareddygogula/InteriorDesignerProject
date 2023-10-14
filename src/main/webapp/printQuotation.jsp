<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/printQuotation.css">
<title>VAMS TROVE - Quotation</title>
</head>
<body>
	<h1 style="color: #a57c3e" align="center">VAMS TROVE</h1>
	<p align="center">
Flat no-2-1, Mouli Towers, 2nd Floor, 1st Block, 40-14-10E, Chandra Mouli Puram,</p>
<p align="center"> Benz Circle, Vijayawada, Andhra Pradesh 520010</p>
<p align="center"><b>GSTIN: 37ACCFA4901C1ZZ</b></p>
	<hr color="black"/>
	<h2 align="center">Quotation</h2>
	
	<div class="idalign">
		
		<div class="alltables">
		<table align = "center">
		<tr>
					<td><b>Quotation ID: </b></td>
					<td> <c:out value="${customerDetails.quotationId}"></c:out> </td>
				</tr>
		<tr>
			<td><b>Quotation Date: </b></td>
			<td> <c:out value="${customerDetails.quotationDate}"></c:out> </td>
		</tr>
		<tr>
			<td><b>Customer Name: </b></td>
			<td> <c:out value="${customerDetails.name}"></c:out> </td>
		</tr>
		
		<tr>
			<td><b>Address: </b></td>
			<td> <c:out value="${customerDetails.address}"></c:out> </td>
		</tr>
		
	</table>

		<table align = "center" >
		<tr>
					<td><b> </b></td>
					<td>.</td>
				</tr>
		
		<tr>
			<td><b>Mobile Number: </b></td>
			<td> <c:out value="${customerDetails.contact}"></c:out> </td>
		</tr>

		<tr>
			<td><b>PAN Number: </b></td>
			<td> <c:out value="${customerDetails.PANOrGSTIN}"></c:out> </td>
		</tr>
		<tr>
			<td><b>Referred By: </b></td>
			<td> <c:out value="${customerDetails.onBoardedBy}"></c:out> </td>
		</tr>
	</table>

	</div>
		
	</div>
	
		

	
	
	<br/><br/><br/>
	
	<table class="displaytable" align = "center">
		<tr align="center">
			<th style="width: auto;">Component Name</th>
			<th>Height(inches)</th>
			<th>Width(inches)</th>
			<th>Area(sq. ft.)</th>
			<th>Quantity</th>
			<th>Price(per sq. ft)*</th>
			<th style="width: 15%;">Amount</th>
		</tr>
		<c:forEach items="${quotList}" var="q">
			<tr>
				<td> <c:out value="${q.name}"></c:out> </td>
				<td> <!--<c:out value="${q.height}"></c:out>--> 
					<c:if test="${q.height == -1}">
						<c:out value="Not Applicable"></c:out>
					</c:if>
					<c:if test="${q.height != -1}">
						<c:out value="${q.height}"></c:out>
					</c:if>
				</td>
				<td> <!--<c:out value="${q.width}"></c:out> -->
					<c:if test="${q.width == -1}">
						<c:out value="Not Applicable"></c:out>
					</c:if>
					<c:if test="${q.width != -1}">
						<c:out value="${q.width}"></c:out>
					</c:if>
				</td>
				<td> <!--<c:out value="${q.width}"></c:out> -->
					<c:if test="${q.area == 1}">
						<c:if test="${q.width != -1}">
							<c:out value="${q.area}"></c:out>
						</c:if>
						<c:if test="${q.width == -1}">
							<c:out value="Not Applicable"></c:out>
						</c:if>
					</c:if>
					<c:if test="${q.area != 1}">
						<c:out value="${q.area}"></c:out>
					</c:if>
				</td>
				<td> <c:out value="${q.quantity}"></c:out> </td>
				<td> <c:out value="${q.price}"></c:out> </td>
				<td> <c:out value="${q.total}"></c:out> </td>
			</tr>
		</c:forEach>
		
		<tr style="border:0">
			<td colspan="6" align="right"><b>Estimated Total: </b></td>
			<td colspan="1" align="center">Rs. <c:out value="${customerDetails.calculatedTotal}"></c:out></td>
		</tr>
		
		<tr style="border:0" >
			<td colspan="6" align="right"><b>Final Total: </b></td>
			<td colspan="1" align="center">Rs. <c:out value="${customerDetails.estimatedTotal}"></c:out></td>
		</tr>
		
	</table>
	
	
	<div class="sign">
		<h3>__________________</h3>
		<p>Authorized Signature</p>
	</div>
	
	<h3 class="printbutton" align="center"><input type="button" onclick="window.print()" value="Print"></h3>
</body>
</html>