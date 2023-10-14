<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">
<link rel="stylesheet" href="/css/nIQ.css">
<meta charset="UTF-8">
<jsp:include page="navbarforadmin.jsp" />
<title>Furniture Quotation | Continue</title>
</head>
<body>
	<br>
	<div class="details">
	<h2 align="center">Added Items</h2>
		<table border="1" align = "center" id="importsTable">
		<thead>
			<tr align="center">
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
	<center>
	<div align="center" class="buttons-dis">
		<button class="opt-buttons1"><a href="/designer/generateImportsQuotation">Delete all fields till now</a></button>
		<button class="opt-buttons2"><a href="/designer/saveImportsQuotation">Save this quotation</a></button>
	</div>
	</center>
	</div>
	<br><br><br>
	<center>
		<div class="card" align="center">
		<h2 align="center">Please Enter Details</h2>
		<br>
			<form action="/designer/addImportItemToQuotation" method="post">
				<table>
					<tr>
						<td> Select Item:  </td>
						<td>
							<select name="imports" required="required" >
								<option value="-1" disabled="disabled" selected="selected">---Select---</option>
								<c:forEach items="${allItems}" var="item">
									<option value="${item.id}"> ${item.id} - ${item.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>Enter Quantity:</td>
						<td> <input type="number" required="required" name="itemquanity" class="did-floating-input"> </td>
					</tr>
					<tr>
						<td>Enter Price:</td>
						<td> <input type="number" required="required" name="itemprice" class="did-floating-input"> </td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button>Continue</button></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
	<br><br><br>	
	
	
	
	<script type="text/javascript">
		new DataTable("#importsTable", {
			order : []
		})
	</script>
	
</body>
<jsp:include page="footerforall.jsp" />
</html>