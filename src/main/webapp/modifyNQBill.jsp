<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="navbarforadmin.jsp" />
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/modifyNQBill.css">
<head>
<meta charset="UTF-8">
<title>Billing | Modification</title>
</head>
<body>
	<br></br>
	<h2 align="center">Modification - Non Quotation Billing</h2>
	<br></br>
	
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
	<br/><br/>
	<div class="details"> 
	<table align="center" border='2' id="nqBillModification">
		<thead>
		<tr>
			<th>Description</th>
			<th>Amount</th>
			<th>Operations</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${billsList}" var="bill">
			<tr>
				<td>${bill.name}</td>
				<td>${bill.amount}</td>
				<td>
					<a href="/designer/deleteNQBillComponent/${bill.cid}/${billSummary.id}"  style="text-decoration: none;">
						<span class="material-symbols-outlined" style="color: red; font-size: 30px;">
						delete
						</span>
					</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<center>
	<div class="buttons-dis">
		<button class="opt-buttons1"><a href="/designer/addNQBillComponent/${billSummary.id}">Add new component</a></button>
		<button class="opt-buttons2"><a href="/designer/printNQBill/${billSummary.id}" target="_blank">Print Quotation</a></button>
	</div>
	</center>
	</div>
	
	<h4 align="center"><b>Total Price: </b>Rs. ${billSummary.price}</h4>
	<h4 align="center"><b>GST:</b>${billSummary.gst}%</h4>
	<h4 align="center"><b>Total Amount: </b>Rs. ${billSummary.amount}</h4>
	<br/>
	
	
	<script type="text/javascript">
		new DataTable("#nqBillModification", {
			order:[]
		});
	</script>
	<br></br>
</body>
<jsp:include page="footerforall.jsp" />
</html>