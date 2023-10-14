<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<jsp:include page="navbarforadmin.jsp" />
<meta charset="UTF-8">
<title>Furniture Quotation | Modifications</title>
<link rel="stylesheet" href="/css/viewQuotations.css">
</head>
<body>
	<h1 align="center">Modify Furniture Quotation</h1>
	<br/>
	<h2 align="center" style="color: blue;">Customer Details</h2>

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
	
	<table align = "center" >
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
	<div class="details"> 
	<h2 align="center" style="color: white">Items Added</h2>
	<table align = "center" border="1" id = "modifcationTable">
		<thead><tr>
			<th>Image</th>
			<th>Reference</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Amount</th>
			<th>Operations</th>
		</tr></thead>
		<tbody>
		<c:forEach items="${quotationTuples}" var="item">
			<tr>
				<td>
					<img src="/designer/viewImportImage/${item.importreference}" width="40%">
				</td>
				<td>${item.importreference}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td>${item.quantity}</td>
				<td>${item.amount}</td>
				<td>
					<a href="/designer/deleteImportQuotationComponent?cid=${item.componentid}&qid=${summaryRecord.id}" style="color: red;">
							<span class="material-symbols-outlined" style="font-size: 30px;">
								delete
							</span></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<center>
	<div class="buttons-dis">
		<button class="opt-buttons1"><a href="/designer/addNewImportItemToQuotation/${summaryRecord.id}">Add new component</a></button>
		<button class="opt-buttons2"><a href="/designer/printImportsQuotation/${summaryRecord.id}" target="_blank">Print Quotation</a></button>
	</div>
	</center>
	</div>
	<br><br>
	<div class="info">
		<p><b>Estimated Total: </b> Rs. <c:out value="${summaryRecord.calculatedAmount}"></c:out></p>
	 	<p><b>Final Total: </b>Rs. <c:out value="${summaryRecord.finalizedAmount}"></c:out></p>
	</div>
	
	<script type="text/javascript">
		new DataTable("#modifcationTable", {
			order : [],
		})
	</script>
	<br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>