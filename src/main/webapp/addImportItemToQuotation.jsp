<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Furniture Quotation | New Item</title>
<jsp:include page="navbarforadmin.jsp" />
<link rel="stylesheet" href="/css/nIQ.css">
</head>
<body>
	
	<h3><a href="/designer/viewImportsQuotation/${qid}" style="display: flex;
	    text-decoration: none;
	    align-items: self-end;
	    margin-left: 2%;
	    font-size: 23px;
	    color: #110ec1;">
		<span class="material-symbols-outlined" >
			navigate_before
		</span>
		<div>
			Back to all Components
		</div>
		</a></h3>
	
	<center>
		<div class="card" align="center">
		<h2 align="center">Enter Details</h2>
		<br>
	<form action="/designer/addImportItemToExistingQuotation/${qid}" method="post">
		<table>
			<tr>
				<td> Select Item:  </td>
				<td>
					<select name="imports" required="required" >
						<option value="">---Select---</option>
						<c:forEach items="${allItems}" var="item">
							<option value="${item.id}"> ${item.id} - ${item.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Enter Quantity:</td>
				<td> <input type="number" required="required" name="itemquanity" class="did-floating-input" min="1"> </td>
			</tr>
			<tr>
				<td>Enter Price:</td>
				<td> <input type="number" required="required" name="itemprice" class="did-floating-input" min="1"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>Save</button></td>
			</tr>
		</table>
	</form>
	</div></center>
</body>
<jsp:include page="footerforall.jsp" />
</html>