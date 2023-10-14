<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/vamb.css">
<head>
<meta charset="UTF-8">
<title>Billing | Modification</title>
<jsp:include page="navbarforadmin.jsp" />
</head>
<body>
	<br><br>
	<h2 align="center">Modify and Check Bill</h2>
	<br/><br/>
	
	<div class="alltables">
		<table align = "center">
			<tr>
				<td><b>Bill Id:</b></td>
				<td>${billDetail.billId}</td>
			</tr>
			<tr>
				<td><b>Name:</b></td>
				<td>${billDetail.customerName}</td>
			</tr>
			<tr>
				<td><b>Date of Billing:</b></td>
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
	<div class="details">
	<table align = "center" border="2" id="billComponents">
		<thead>
		<tr>
			<th>Description</th>
			<th>Amount</th>
			<th>Operations</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${billComponents}" var="bill">
			<tr>
				<td>${bill.componentName}</td>
				<td>${bill.amount}</td>
				<td>
					<a href="/designer/modifyBillComponent/${bill.billComponentId}/${billDetail.billId}"><span class="material-symbols-outlined" style="font-size: 30px; color: yellow;">
						edit
					</span></a> &nbsp;</a>
					<a href="/designer/deleteBillComponent/${bill.billComponentId}/${billDetail.billId}"><span class="material-symbols-outlined" style="font-size: 30px; color: red;">
						delete
					</span></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<center>
		<button class="opt-buttons2"><a href="/designer/printBill/${billDetail.billId}" target="_blank">Print</a></button>
	</center>
	</div>
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
	
	<script type="text/javascript">
		new DataTable("#billComponents");
	</script>
	
	<br/><br/><br/>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>