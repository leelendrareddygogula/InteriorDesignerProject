<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="navbarforadmin.jsp" />
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<head>
<meta charset="UTF-8">
<title>Quotation | Modification</title>
<link rel="stylesheet" href="/css/viewQuotations.css">
</head>
<body>
	<br><br>
	<h1 align="center">Your Quotation</h1><br/>
	<h2 align="center" style="color: blue;">Customer Details</h2>
	
	
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
	
	<br/><br/>
	
	<div class="details"> 
	<h2 align="center" style="color: red;">Perform Modifications if Necessary</h2>
	<table border="1" align = "center" id="quotationComponentsTable">
		<thead>
		<tr align="center">
			<th>Description</th>
			<th>Height(inches)</th>
			<th>Width(inches)</th>
			<th>Area(sq. ft.)</th>
			<th>Quantity</th>
			<th>Price(per sq. ft.)</th>
			<th>Amount(Rs)</th>
			<th>Operations</th>
		</tr>
		<thead>
		<tbody>
		<c:forEach items="${quotComponents}" var="q">
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
				<td>
					<a href="/designer/deleteComponent/${q.componentId}/${q.quotationId}"style="color: red;">
							<span class="material-symbols-outlined" style="font-size: 30px;">
								delete
							</span></a> &nbsp;
					<a href="/designer/modifyQuotationComponent/${q.componentId}/${q.quotationId}"style="color: yellow;">
							<span class="material-symbols-outlined" style="font-size: 30px;">
								edit
							</span></a> &nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<center>
	<div class="buttons-dis">
		<button class="opt-buttons1"><a href="/designer/addComponentToQuot/${qid}">Add new component</a></button>
		<button class="opt-buttons2"><a href="/designer/printQuotation/${qid}" target="_blank">Print Quotation</a></button>
	</div>
	</center>
	</div>
	<br>
	<div class="info">
		<p><b>Estimated Total: </b> Rs. <c:out value="${customerDetails.calculatedTotal}"></c:out></p>
	 	<p><b>Final Total: </b>Rs. <c:out value="${customerDetails.estimatedTotal}"></c:out></p>
	</div>
	
	<br><br>
	 
	 <h3 align="center"></h3>
	 <script type="text/javascript">
	 	new DataTable("#quotationComponentsTable", {
	 		order : []
	 	});
	 </script>
	 
	
</body>
<jsp:include page="footerforall.jsp" />
</html>