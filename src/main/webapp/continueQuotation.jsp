<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/newQuotationPage.css">
<title>Quotation | Continue</title>
</head>
<body>
<br><br>
	
	
	<div class="details">
	<h2 align="center" style="color: white">You Already Added</h2>
		<table border="1" align = "center" id="continueQuotationTable">
			<thead>
			<tr align="center">
				<th>Description</th>
				<th>Height(inches)</th>
				<th>Width(inches)</th>
				<th>Area(sq. ft.)</th>
				<th>Quantity</th>
				<th>Price(per sq. ft.)</th>
				<th>Amount(Rs)</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${previousComponents}" var="q">
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
			</tbody>
		</table>
		<center>
	<div class="buttons-dis">
		<button class="opt-buttons1"><a href="/designer/newQuotation">Delete all fields till now</a></button>
		<button class="opt-buttons2"><a href="/designer/saveQuotation">Save this quotation</a></button>
	</div>
	</center>
	</div>
	<br><br>
	
	<center>
	<div class="card">
	<h2 align="center" style="color: black;">Continue Your Quotation</h2>
		<form action="/designer/addComponent" method="post">
			<table>
				<tr>
					<td> Enter description: </td>
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
			</table>
			<br>
			<center>
				<button class="generate-add" type="submit">
					<span class="material-symbols-outlined">
						receipt_long
					</span>
					<div style="padding: 5%;">
						Add Component
					</div>
				</button>
			</center>
		</form>
	</div>
	</center>
	<script type="text/javascript">
		new DataTable("#continueQuotationTable", {
			order : []
		});
	</script>
	
	<br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>