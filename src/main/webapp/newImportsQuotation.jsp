<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Furniture Quotation | New</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/nIQ.css">
</head>
<body>
<br><br><br>
	<center>
		<div class="card" align="center">
		<h2 align="center">New Furniture Quotation</h2>
		<br>
			<form action="/designer/addImportItemToQuotation" method="post">
				<table>
					<tr>
						<td> Select Item:  </td>
						<td>
							<select name="imports" required="required" >
								<option value="" disabled="disabled" selected="selected">---Select---</option>
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
</body>
<jsp:include page="footerforall.jsp" />
</html>