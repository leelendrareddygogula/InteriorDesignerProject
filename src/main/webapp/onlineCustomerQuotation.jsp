<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start Here</title>
<jsp:include page="homenavbar.jsp" />
<link rel="stylesheet" href="/css/oCQ.css">
</head>
<body>
	<br><br><br>
	<center>
		<div class="card" align="center">
		<h2 align="center" style="color: black;">Please Enter Details</h2>
	<br>
			<form action="/customer/quotation/continue" method="post">
				<table align="center">
				<tr>
					<td>Select Material:</td>
					<td><select name="comptype" required="required">
							<option value="" disabled="disabled" selected="selected">---Select---</option>
							<c:forEach items="${materialList}" var="item">
								<option value="${item.id}">${item.name}- Rs.
									${item.price}</option>
							</c:forEach>
					</select>
					</td>
					</tr>
					<tr>
						<td>Enter name of component:</td>
						<td><input type="text" name="compname" required="required" class="did-floating-input">
						</td>
					</tr>
					<tr>
						<td>Enter height(inches):</td>
						<td><input type="number" name="compheight"
							required="required" class="did-floating-input" min="1"></td>
					</tr>
					<tr>
						<td>Enter width(inches):</td>
						<td><input type="number" name="compwidth" required="required" class="did-floating-input" min="1">
						</td>
					</tr>
					<tr>
						<td>Enter Quantity:</td>
						<td><input type="number" name="compquantity"
							required="required" class="did-floating-input" min="1" pattern="[0-9.]+"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button>Continue</button></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
	<br />
	<br />
	<a href="/home">Home</a>
</body>
<jsp:include page="footerforall.jsp" />
</html>