<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="/js/jquery.js" ></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/nonQuotationBills.css">
<head>
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>External Billing | All</title>
</head>
<body>
	<br></br>
	<br></br>
	
	<div class="details">
	<h2 align="center">Non Quotation Bills</h2>
		<table align="center" border="1" id="nonQuotationBills">
			<thead>
			<tr>
				<th>Bill Id</th>
				<th>Date</th>
				<th>Customer Name</th>
				<th>Mobile</th>
				<th>Bill Price</th>
				<th>GST</th>
				<th>Final Amount</th>
				<th>Operations</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allBills}" var="bill">
				<tr>
					<td>${bill.id}</td>
					<td>${bill.billDate}</td>
					<td>${bill.customerName}</td>
					<td>${bill.mobileNumber}</td>
					<td>${bill.price}</td>
					<td>${bill.gst}</td>
					<td>${bill.amount}</td>
					<td style="display: flex; justify-content: center;">
						<a href="/designer/printNQBill/${bill.id}" target="_blank"><span class="material-symbols-outlined" style="font-size: 30px; color: lime;">
							Print
						</span>&nbsp;&nbsp;&nbsp;</a> 
						<a href="/designer/viewNQBill/${bill.id}"><span class="material-symbols-outlined" style="font-size: 30px; color: yellow;">
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
		new DataTable("#nonQuotationBills", {
			order: []
		});
	</script>

</body>
<jsp:include page="footerforall.jsp" />
</html>