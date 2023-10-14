<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/cDIB.css">
<meta charset="UTF-8">
<title>Furniture Quotation | Customer Details </title>
<jsp:include page="navbarforadmin.jsp" />
</head>
<body>
	
	<center>
		<div class="card">
		<h2 align="center">Customer Details</h2>
	<form action="/designer/saveCustomerDetailsImportsQuotation" method="post">
	<table>
		<tr>
			<td> Quotation of ID: </td>
			<td> <input type="number" name="quotId" required="required" readonly="readonly" value="${quotId}"></td>
		</tr>
		<tr>
			<td> Enter Name of Customer:  </td>
			<td> <input type="text" name="custname" required="required"></td>
		</tr>
		
		<tr>
			<td> Enter Address of Customer:  </td>
			<td> <input type="text" name="custaddress" required="required"></td>
		</tr>
		<tr>
			<td> Enter Name of Contact Person:  </td>
			<td> <input type="text" name="contname" required="required"></td>
		</tr>
		<tr>
			<td> Enter Mobile Number of Customer:  </td>
			<td> <input type="number" name="mobilenum" required="required"></td>
		</tr>
		<tr>
			<td> Enter PAN or GSTIN of Customer:  </td>
			<td> <input type="text" name="panorgst"></td>
		</tr>
		<tr>
			<td> Total Amount Calculated:  </td>
			<td> <input type="number" name="finaltotal" required="required" readonly="readonly" value="${totalamount}"></td>
		</tr>
		<tr>
			<td> Enter Finalized Amount:  </td>
			<td> <input type="number" name="finalamount" required="required"></td>
		</tr>
	</table>
	
	<center>
					<button class="generate-continue" type="submit">
						<span class="material-symbols-outlined">
							save
						</span>
						<div style="padding: 5%;">
							Save
						</div>
					</button>
				</center>
	
	</form>
	<br>
			<center>
					<button class="generate-continue" type="submit" style="background: red;">
					<a href="/designer/generateImportsQuotation" style="text-decoration: none; color: white; font-size: 20px;">
						<div style="padding: 5%;">
							Cancel
						</div>
					</a>
					</button>
				</center>
	</div>
	
	</center>
	
	
	<br/><br/>
	<h2 align="center">Items added are, </h2>
	<div class="com">
	<table align = "center" style="border: 2px solid white;
    width: 95%;
    font-size: 20px;">
		<thead>
			<tr>
				<th>Reference</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${addedList}" var="item">
				<tr>
					<td>${item.importreference}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.quantity}</td>
					<td>${item.amount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<br><br><br><br>
</body>
<jsp:include page="footerforall.jsp" />
</html>