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

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<link rel="stylesheet" href="/css/viewQuotations.css">
<jsp:include page="navbarforadmin.jsp" />
<title>Quotations | All</title>
</head>
<body>
	<br/><br/>
	<br/><br/>
	<h3 align="center" style="color: green;"> <c:out value="${quotAndCustMsg}"></c:out> </h3>
	<div class="details"> 
	<h2 align="center" style="color: white">All Quotations</h2>
		<table align = "center" border="1" id="AllQuotationTable">
			<thead>
			<tr>
				<th>Quotation ID</th>
				<th>Customer Name</th>
				<th>Quotation Date</th>
				<th>Customer Contact</th>
				<th>Customer Address</th>
				<th>Remaining Balance</th>
				<th>Reffered By</th>
				<th>Operations</th>
			</tr></thead>
			<tbody>
			<c:forEach items="${customersList}" var="customer">
				<tr>
					<td> <c:out value="${customer.quotationId}"></c:out> </td>
					<td> <c:out value="${customer.name}"></c:out> </td>
					<td> <c:out value="${customer.quotationDate}"></c:out> </td>
					<td> <c:out value="${customer.contact}"></c:out> </td>
					<td> <c:out value="${customer.address}"></c:out> </td>
					<td> <c:out value="${customer.remainingBalance}"></c:out> </td>
					<td> <c:out value="${customer.onBoardedBy}"></c:out> </td>
					<td>
						<a href="/designer/printQuotation/${customer.quotationId}" target="_blank" style="color: lime;">
							<span class="material-symbols-outlined" style="font-size: 30px;">
								print
							</span></a> &nbsp;
						<a href="/designer/viewQuotation/${customer.quotationId}" style="color: yellow;">
						<span class="material-symbols-outlined" style="font-size: 30px;">
								edit
							</span></a>&nbsp;
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<br><br></br></br>
	
	<script type="text/javascript">
		new DataTable("#AllQuotationTable", {
			order : []
		});
	</script>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>