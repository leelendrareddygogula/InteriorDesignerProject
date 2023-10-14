<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/quotationBills.css">
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>Billing | All</title>
<link rel="icon" href="/images/Logo.png" sizes="32x32" type="image/png">
</head>
	
<body>
	<br></br>
	<br></br>
	<h4> <c:out value="${billingMsg}"></c:out> </h4>
	<div class="details">
	<h2 align="center" style="color: white;">Quotation Bills</h2>
		<table border="1" align = "center" id="allQuotationBillsTable">
			<thead><tr>
				<th>Bill Id</th>
				<th>Bill Date</th>
				<th>Customer Name</th>
				<th>Bill Price</th>
				<th>GST (%)</th>
				<th>Total Amount</th>
				<th>Operations</th>
			</tr></thead>
			<tbody>
			<c:forEach items="${allQuotationBills}" var="bill">
				<tr>
					<td>${bill.billId}</td>
					<td>${bill.billDate}</td>
					<td>${bill.customerName}</td>
					<td>${bill.totalPrice}</td>
					<td>${bill.gstPercentage}</td>
					<td>${bill.totalAmount}</td>
					<td style="display: flex; justify-content: center;">
						<a href="/designer/printBill/${bill.billId}" target="_blank" style="margin-right: 15px; color: lime;"><span class="material-symbols-outlined" style="font-size: 30px;">
							Print
						</span></a><br> &nbsp;&nbsp;
						<a href="/designer/viewBill/${bill.billId}" style="color:yellow;"><span class="material-symbols-outlined" style="font-size: 30px;">
							Edit
						</span></a>
					</td>
				</tr>			
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<br/><br/>
	
	<script type="text/javascript">
		new DataTable("#allQuotationBillsTable", 
				{
			order : [0, 'desc']
				});
	</script>
	
	
</body>
<jsp:include page="footerforall.jsp" />
</html>