<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="homenavbar.jsp" />
<script src="/js/jquery.js"></script>
<script src="/js/datatables.js"></script>
<link rel="stylesheet" href="/css/datatables.css">

<link rel="stylesheet" href="/css/oCQC.css">
<title>Please Continue</title>
</head>
<body>
	<br>
	<div class="details">
	<h2 style="color: white;" align="center">You Added</h2>
		<table align="center" border="1"  id="tablequot">
			<thead>
			<tr>
				<th>Name</th>
				<th>Height (in inches) </th>
				<th>Width (in inches)</th>
				<th>Area (Sq. Foot)</th>
				<th>Quantity</th>
				<th>Material</th>
				<th>Price(per Sq. Ft.) *</th>
				<th>Amount</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${addedList}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>
						<c:if test="${item.height == -1}"> <c:out value="Not Appicable"></c:out> </c:if>
						<c:if test="${item.height != -1}"> <c:out value="${item.height}"></c:out> </c:if>
					</td>
					<td>
						<c:if test="${item.width == -1}"> <c:out value="Not Appicable"></c:out> </c:if>
						<c:if test="${item.width != -1}"> <c:out value="${item.width}"></c:out> </c:if>
					</td>
					<td>
						<c:if test="${item.area == -1}"> <c:out value="Not Appicable"></c:out> </c:if>
						<c:if test="${item.area != -1}"> <c:out value="${item.area}"></c:out> </c:if>
					</td>
					<td>${item.quantity}</td>
					<td>${item.material}</td>
					<td>${item.price}</td>
					<td>${item.minAmount} - ${item.maxAmount}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<center>
	<div class="buttons-dis">
		<button class="opt-buttons1"><a href="/customer/quotation/new">Delete all fields till now</a></button>
		<button class="opt-buttons2"><a href="/customer/details">Print</a></button>
	</div>
	</center>
		</div>
	<center>
	<div class="card">
	<h2 align="center" style="color: black;">Please Continue</h2>
	<br>
	<form action="/customer/quotation/continue" method="post">
		<table align="center">
			<tr>
				<td>Select Material:</td>
				<td><select class="selectclass" name="comptype" required="required">
						<option value="-1" disabled="disabled" selected="selected">---Select---</option>
						<c:forEach items="${materialList}" var="item">
							<option value="${item.id}">${item.name}- Rs. ${item.price}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter name of component:</td>
				<td><input type="text" name="compname" required="required">
				</td>
			</tr>
			<tr>
				<td>Enter height(inches):</td>
				<td><input type="number" name="compheight" required="required">
				</td>
			</tr>
			<tr>
				<td>Enter width(inches):</td>
				<td><input type="number" name="compwidth" required="required">
				</td>
			</tr>
			<tr>
				<td>Enter Quantity:</td>
				<td><input type="number" name="compquantity"
					required="required"></td>
			</tr>
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
	<br/><br/>
	<script type="text/javascript">
		new DataTable("#tablequot", {
			order : []
		});
	</script>
</body>

<jsp:include page="footerforall.jsp" />
</html>